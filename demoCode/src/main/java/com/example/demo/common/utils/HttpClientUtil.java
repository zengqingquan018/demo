package com.example.demo.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtil {

    //private static final NLogback logger = NLogback.getLogger(HttpClientUtil.class);
    private static final int timeOut = 5 * 1000;
    private static PoolingHttpClientConnectionManager connectionManager;

    private static String CHARSET = "UTF-8";

    public static final String CONTENT = "content";
    public static final String STATUSCODE = "statusCode";
    private static HttpClientUtil httpUtil = new HttpClientUtil();

    private HttpClientUtil() {
    }

    public static HttpClientUtil getInstance() {
        return httpUtil;
    }

    private void init() {
        if (connectionManager == null) {
            connectionManager = new PoolingHttpClientConnectionManager();
            connectionManager.setMaxTotal(100);// 整个连接池最大连接数
            connectionManager.setDefaultMaxPerRoute(10);// 每路由最大连接数，默认值是10
        }
    }


    private static void config(HttpRequestBase httpRequestBase) {
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return HttpClient对象
     */
    private CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }

    /**
     * 发送POST请求
     *
     * @param params 请求参数
     * @return 返回map集合，响应体内容key为content
     * @throws UnsupportedEncodingException
     */
    public Map<String, String> httpPOST(HttpPost httpPost, Map<String, String> params) {
        Map<String, String> result = new HashMap<>();
        try {
            config(httpPost);
            if (params != null) {
                ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }
            result = getResult(httpPost);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    /**
     * 发送POST请求
     *
     * @param params 请求参数
     * @return 返回map集合，响应体内容key为content
     */
    public String postStr(String url, String params, Map<String, String> headerMap) {
        Map<String, String> result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            config(httpPost);
            if (!StringUtils.isEmpty(params)) {
                httpPost.setEntity(new StringEntity(params, StandardCharsets.UTF_8));
            }
            if (!ObjectUtils.isEmpty(headerMap)) {
                headerMap.forEach((k, v) -> httpPost.addHeader(k, v));
            }
            result = getResult(httpPost);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!ObjectUtils.isEmpty(result)) {
            return result.get("content");
        }
        return null;
    }


    /**
     * 设置请求参数
     *
     * @param params 请求参数
     * @return ArrayList<NameValuePair>
     */
    private ArrayList<NameValuePair> covertParams2NVPS(Map<String, String> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }

        return pairs;
    }

    /**
     * 处理HTTP请求
     *
     * @param request
     * @return
     */
    private Map<String, String> getResult(HttpRequestBase request) throws Exception {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        Map<String, String> result = new HashMap<String, String>();
        try {
            response = httpClient.execute(request);
            String statusCode = response.getStatusLine().getStatusCode() + "";
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String content = EntityUtils.toString(entity, CHARSET);
                result.put(CONTENT, content);
                result.put(STATUSCODE, statusCode);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                //logger.error("",e);
            }
        }
        return result;
    }

}
