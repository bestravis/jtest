package net.voovo.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * File Name: DSHSendMessageUtil.java<br>
 * Created Date: 2018年3月15日 上午9:54:12<br>
 * Modified Date: 2018年3月15日 上午9:54:12<br>
 * Version: 1.0<br>
 */

public class DSHSendMessageUtil {
    
    private static final String OPER_ID = "ceshfj2";
    private static final String OPER_PASS = "jcUiROHM";
    private static final String SEND_URL = "http://qxtsms.guodulink.net:8000/QxtSms/QxtFirewall";
    private static final String SEND_TIME = "";
    private static final String VALID_TIME = "";
    private static final String APPEND_ID = "888";
    
    
    
    /**
     * Test
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        try {
            String content = "http://news.sina.com.cn/o/2018-03-15/doc-ifyshvuy1243084.shtml";
            String mobiles = "13918159104,15216865591";
            
            /* post方式发送消息 */
            boolean postResponse = DSHSendMessageUtil.postSendMsg(content, mobiles);
            System.out.println("post方式返回的响应为：" + postResponse);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    
    /**
     * 发送短信
     * @param content 短信内容
     * @param mobiles 手机号,多个手机号可用“,”隔开
     * @return boolean
     */
    public static boolean postSendMsg(String content, String mobiles) throws Exception {
        boolean flag = false;
        try {
            /* 将内容用URLEncoder编一次GBK */
            String encoderContent = "";
            encoderContent = URLEncoder.encode(content, "GBK");
            
            /* 消息参数 */
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OperID=").append(OPER_ID)
                         .append("&OperPass=").append(OPER_PASS)
                         .append("&SendTime=").append(SEND_TIME)
                         .append("&ValidTime=").append(VALID_TIME)
                         .append("&AppendID=").append(APPEND_ID)
                         .append("&DesMobile=").append(mobiles.trim())
                         .append("&Content=").append(encoderContent)
                         .append("&ContentType=").append("8");
            
            /* 使用post方式发送消息 */
            String response = postURL(stringBuilder.toString(), SEND_URL);
            if (response.indexOf("<code>01</code>") >= 0) {
                flag = true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    

    /**
     * @param commString 需要发送的url参数串
     * @param address 需要发送的url地址
     * @return 国都返回的XML格式的串
     * @catch Exception
     */
    public static String postURL(String commString, String address) {
        String rec_string = "";
        URL url = null;
        HttpURLConnection urlConn = null;
        try {
            /* 得到url地址的URL类 */
            url = new URL(address);
            /* 获得打开需要发送的url连接 */
            urlConn = (HttpURLConnection) url.openConnection();
            /* 设置连接超时时间 */
            urlConn.setConnectTimeout(30000);
            /* 设置读取响应超时时间 */
            urlConn.setReadTimeout(30000);
            /* 设置post发送方式 */
            urlConn.setRequestMethod("POST");
            /* 发送commString */
            urlConn.setDoOutput(true);
            urlConn.setDoInput(true);
            OutputStream out = urlConn.getOutputStream();
            out.write(commString.getBytes());
            out.flush();
            out.close();
            /* 发送完毕 获取返回流，解析流数据 */
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "GBK"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            rec_string = sb.toString().trim();
            rd.close();
        } catch (Exception e) {
            rec_string = "-107";
        } finally {
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
        return rec_string;
    }
    
}