package net.voovo.push;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

/**
 * Author : YongBo Xie </br>
 * File Name: SmsSendThreadUtils.java </br>
 * Created Date: 2018年3月26日 下午2:17:42 </br>
 * Modified Date: 2018年3月26日 下午2:17:42 </br>
 * Version: 1.0 </br>
*/

public class SmsSendThread implements Runnable {

    private static Logger logger = Logger.getLogger(SmsSendThread.class);
    

    private List<String> mobileList;//手机号码
    private String content;//短信内容
    private int currentIndex;//当前索引
    private int rows;//处理数据条数
    private CountDownLatch doneSignal;//处理线程条数

    public SmsSendThread(List<String> mobileList, String content, int currentIndex, int rows, CountDownLatch doneSignal) {
        this.mobileList = mobileList;
        this.content = content;
        this.currentIndex = currentIndex;
        this.rows = rows;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        // 查询当前的block范围内的发送的手机号=>筛选目标客户群手机号---------
        String mobiles = filterPhones(mobileList, currentIndex, rows);
        try {
            DSHSendMessageUtil.postSendMsg(content, mobiles);
        } catch (Exception e) {
            logger.error("send message thread exception=>{" + mobiles + "}{" + e.getMessage() + "}");
            e.printStackTrace();
        } finally {
            doneSignal.countDown();//工人完成工作，计数器减一
        }
    }

    /**
     * 筛选目标客户群手机号
     * @param mobileList 手机号码
     * @param currentIndex 当前索引
     * @param rows 处理数据条数
     * @return
     */
    private String filterPhones(List<String> mobileList, int currentIndex, int rows) {
        int startIndex = currentIndex * rows;
        int endIndex = (currentIndex + 1) * rows;
        if (endIndex > mobileList.size()) {
            endIndex = mobileList.size();
        }
        String mobiles = "";
        for (int i = startIndex; i < endIndex; i++) {
            mobiles = mobileList.get(i) + "," + mobiles;
        }
        return mobiles;
    }

}