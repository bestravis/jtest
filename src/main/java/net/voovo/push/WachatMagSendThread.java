package net.voovo.push;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;




/**
 * Author : YongBo Xie </br>
 * File Name: WachatMagSendThread.java </br>
 * Created Date: 2018年3月26日 下午4:11:23 </br>
 * Modified Date: 2018年3月26日 下午4:11:23 </br>
 * Version: 1.0 </br>
*/

public class WachatMagSendThread implements Runnable {

    private static Logger logger = Logger.getLogger(WachatMagSendThread.class);
    
    private String accessToken;//公众号token
    private List<String> openIdList;//微信OpenID列表
    private String content;//消息内容
    private int currentIndex;//当前索引
    private int rows;//处理数据条数
    private CountDownLatch doneSignal;//处理线程条数

    public WachatMagSendThread(String accessToken, List<String> openIdList, String content, int currentIndex, int rows, CountDownLatch doneSignal) {
        this.accessToken = accessToken;
        this.openIdList = openIdList;
        this.content = content;
        this.currentIndex = currentIndex;
        this.rows = rows;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        // 查询当前的block范围内的发送的OpenID---------
        JSONArray openIdArray = filterOpenIds(openIdList, currentIndex, rows);
        try {
            // 设置发送消息的参数
            JSONObject msgJson = new JSONObject();
            msgJson.put("touser", openIdArray);
            msgJson.put("msgtype", "text");
            JSONObject contentJson = new JSONObject();
            contentJson.put("content", content);
            msgJson.put("text", contentJson);
            
            DSHWechatAPIHander.sendMessage(accessToken, msgJson.toString());
        } catch (Exception e) {
            logger.error("send message thread exception=>{" + openIdArray.toString() + "}{" + e.getMessage() + "}");
            e.printStackTrace();
        } finally {
            doneSignal.countDown();//工人完成工作，计数器减一
        }
    }

    /**
     * 筛选目标客户群OpenID
     * @param openIdList OpenID
     * @param currentIndex 当前索引
     * @param rows 处理数据条数
     * @return
     */
    private JSONArray filterOpenIds(List<String> openIdList, int currentIndex, int rows) {
        int startIndex = currentIndex * rows;
        int endIndex = (currentIndex + 1) * rows;
        if (endIndex > openIdList.size()) {
            endIndex = openIdList.size();
        }
        JSONArray openIdArray = new JSONArray();
        for (int i = startIndex; i < endIndex; i++) {
            openIdArray.add(openIdList.get(i));
        }
        return openIdArray;
    }

}
