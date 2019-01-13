package net.voovo.push;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * Author : YongBo Xie </br>
 * File Name: WechatAPIHander.java </br>
 * Created Date: 2018年3月13日 下午6:29:00 </br>
 * Modified Date: 2018年3月13日 下午6:29:00 </br>
 * Version: 1.0 </br>
 */

public class DSHWechatAPIHander {
    private static Logger logger = Logger.getLogger(DSHWechatAPIHander.class);

    /**
     * 主动推送信息接口(群发)
     */
    private static String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token={0}";

    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static HttpClientBuilder httpBuilder = null;
    private static RequestConfig requestConfig = null;

    private static int MAXCONNECTION = 10;

    private static int DEFAULTMAXCONNECTION = 5;

    private static String IP = "127.0.0.1";
    private static int PORT = 8888;

    static {
        // 设置http的状态参数
        requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();

        HttpHost target = new HttpHost(IP, PORT);
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAXCONNECTION);// 客户端总并行链接最大数
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);// 每个主机的最大并行链接数
        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
        httpBuilder = HttpClients.custom();
        httpBuilder.setConnectionManager(connectionManager);
    }

    public static CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = httpBuilder.build();
        return httpClient;
    }

    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if ("post".equals(method)) {
            reqMethod = RequestBuilder.post().setUri(url).addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();
        } else if ("get".equals(method)) {
            reqMethod = RequestBuilder.get().setUri(url).addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();
        }
        return reqMethod;
    }

    /**
     * @desc 推送信息
     * @param token
     * @param msg
     * @return
     */
    public static void sendMessage(String token, String msg) {
        try {
            logger.info("\n\nsendMessage start.token:" + token + ",msg:" + msg);

            String url = MessageFormat.format(SEND_MSG_URL, token);
            // 创建默认的httpClient实例.
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // 创建httppost
            HttpPost httppost = new HttpPost(url);
            // 设置发送消息的参数
            // 这里必须是一个合法的json格式数据,每个字段的意义可以查看上面连接的说明,content后面的test是要发送给用户的数据,这里是群发给所有人
//            msg = "{\"filter\":{\"is_to_all\":true},\"text\":{\"content\":\"test\"},\"msgtype\":\"text\"}\"";

            StringEntity sEntity;
            try {
                sEntity = new StringEntity(msg);
                // 解决中文乱码的问题
                sEntity.setContentEncoding("UTF-8");
                sEntity.setContentType("application/json");
                httppost.setEntity(sEntity);
                System.out.println("executing request " + httppost.getURI());
                // 发送请求
                CloseableHttpResponse response = httpclient.execute(httppost);
                try {
                    HttpEntity hEntity = response.getEntity();
                    if (hEntity != null) {
                        System.out.println("--------------------------------------");
                        System.out.println("Response content: " + EntityUtils.toString(hEntity, "UTF-8"));
                        System.out.println("--------------------------------------");
                    }
                } finally {
                    response.close();
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接,释放资源
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            logger.error("get user info exception", e);
        }
    }

    public static void main(String args[]) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("account", "");
        map.put("password", "");

        HttpClient client = getConnection();
        HttpUriRequest post = getRequestMethod(map, "http://baidu.com", "post");
        HttpResponse response = client.execute(post);

        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String message = EntityUtils.toString(entity, "utf-8");
            System.out.println(message);
        } else {
            System.out.println("请求失败");
        }
    }
}