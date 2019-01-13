package net.voovo.push;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * Author : YongBo Xie </br>
 * File Name: DSHMessageAndSmsSendThreadUtil.java </br>
 * Created Date: 2018年3月26日 下午2:59:46 </br>
 * Modified Date: 2018年3月26日 下午2:59:46 </br>
 * Version: 1.0 </br>
 */

public class DSHWechatMsgAndSmsSendThreadUtil {

    private static Logger logger = Logger.getLogger(DSHWechatMsgAndSmsSendThreadUtil.class);
    
    public static void main(String[] args) {
        List<String> mobileList = new ArrayList<>();
        mobileList.add("17721111111");
        mobileList.add("15223333333");
        
        String content = "SCRM 多线程发送短信测试";
        
        try {
            sendSMS(mobileList, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送短信
     * 
     * @param mobileList
     *            手机号码
     * @param content
     *            短信内容
     * @throws Exception
     */
    public static void sendSMS(List<String> mobileList, String content) throws Exception {
        try {
            logger.info("send message start...");
            long startTime = System.currentTimeMillis();
            BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(20000);
            ThreadPoolExecutor executors = new ThreadPoolExecutor(5, 10, 60000, TimeUnit.SECONDS, queue);

            // 要推送的用户总数
            int count = mobileList.size();
            logger.info("message all count=" + count);
            // 初始每个线程处理的用户数量
            final int eveLength = 5;
            // 计算处理所有用户需要的线程数量
            int eveBlocks = count / eveLength + (count % eveLength != 0 ? 1 : 0);
            logger.info("need thread's count=" + eveBlocks);
            // 线程计数器
            CountDownLatch doneSignal = new CountDownLatch(eveBlocks);

            // 开启线程处理
            int doneCount = 0;
            for (int page = 0; page < eveBlocks; page++) { /* blocks太大可以再细分重新调度 */
                content = content + ",线程" + (page + 1);
                SmsSendThread ms = new SmsSendThread(mobileList, content, page, eveLength, doneSignal);
                executors.execute(ms);
                // logger.info("start thread =>{}",page+1);
                doneCount++;
            }
            doneSignal.await();// 等待所有计数器线程执行完
            long endTime = System.currentTimeMillis();
            logger.info("send message all thread ends!time(s)=" + (startTime - endTime) / 1000);
            logger.info("all thread count=" + doneCount);
        } catch (Exception e) {
            logger.error("send message error=>{}", e);
        }
    }
    
    /**
     * 微信公众号推送消息
     * @param accessToken 公众号token
     * @param openIdList 微信OpenID列表
     * @param content 消息内容
     * @throws Exception
     */
    public static void sendWechatMsg(String accessToken, List<String> openIdList, String content) throws Exception {
        try {
            logger.info("send message start...");
            long startTime = System.currentTimeMillis();
            BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(20000);
            ThreadPoolExecutor executors = new ThreadPoolExecutor(5, 10, 60000, TimeUnit.SECONDS, queue);

            // 要推送的用户总数
            int count = openIdList.size();
            logger.info("message all count=" + count);
            // 初始每个线程处理的用户数量
            final int eveLength = 2000;
            // 计算处理所有用户需要的线程数量
            int eveBlocks = count / eveLength + (count % eveLength != 0 ? 1 : 0);
            logger.info("need thread's count=" + eveBlocks);
            // 线程计数器
            CountDownLatch doneSignal = new CountDownLatch(eveBlocks);

            // 开启线程处理
            int doneCount = 0;
            for (int page = 0; page < eveBlocks; page++) { /* blocks太大可以再细分重新调度 */
                WachatMagSendThread ms = new WachatMagSendThread(accessToken, openIdList, content, page, eveLength, doneSignal);
                executors.execute(ms);
                // logger.info("start thread =>{}",page+1);
                doneCount++;
            }
            doneSignal.await();// 等待所有计数器线程执行完
            long endTime = System.currentTimeMillis();
            logger.info("send message all thread ends!time(s)=" + (startTime - endTime) / 1000);
            logger.info("all thread count=" + doneCount);
        } catch (Exception e) {
            logger.error("send message error=>{}", e);
        }
    }

}