package com.example.demo.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

/**
 * 描述：Http连接
 *
 * @author zqq
 * @date 2020/4/13 17:15
 */
public class HttpClientUtils {
    private static PoolingHttpClientConnectionManager cm;
    private static final int TIME_OUT = 5 * 1000;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    /**
     * 描述: 初始化请求池
     *
     * @param
     * @return
     * @throws
     * @author
     * @date 2020/4/14 9:11
     */
    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            // 整个连接池最大连接数
            cm.setMaxTotal(100);
            // 每路由最大连接数，默认值是10
            cm.setDefaultMaxPerRoute(10);
        }
    }


    /**
     * 描述:设置请求超时时间
     *
     * @param httpRequestBase
     * @return
     * @throws
     * @author zqq
     * @date 2020/4/14 9:11
     */
    private static void config(HttpRequestBase httpRequestBase) {
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(TIME_OUT)
                .setConnectTimeout(TIME_OUT).setSocketTimeout(TIME_OUT).build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * 描述:通过连接池获取连接
     *
     * @param
     * @return {@link CloseableHttpClient}
     * @throws
     * @author zqq
     * @date 2020/4/14 9:12
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(cm).build();
    }

   /**
    * 描述:get请求，不需要参数或者参数已拼接好
    *
    * @param url
    * @return {@link String}
    * @throws
    * @author zqq
    * @date 2020/4/14 9:12
    */
    public static String httpGetRequest(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    /**
     * 描述:get请求，未拼接参数
     *
     * @param url
     * @param params
     * @return {@link String}
     * @throws
     * @author zqq
     * @date 2020/4/14 9:12
     */
    public static String httpGetRequest(String url, Map<String, Object> params) throws URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);
        HttpGet httpGet = new HttpGet(ub.build());
        return getResult(httpGet);
    }

    /**
     * 描述:get请求，未拼接参数，且自定义header
     *
     * @param url
     * @param headers
     * @param params
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:13
     */
    public static String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)
            throws URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);
        HttpGet httpGet = new HttpGet(ub.build());
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet);
    }

    /**
     * 描述:无参数post请求
     *
     * @param url
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:14
     */
    public static String httpPostRequest(String url) {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

    /**
     * 描述:post请求，参数为JSON
     *
     * @param url
     * @param json
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:14
     */
    public static String httpPostRequestJson(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json, UTF_8);
        entity.setContentEncoding(UTF_8);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        return getResult(httpPost);
    }
    /**
     * 描述:post请求，参数为Map
     *
     * @param url
     * @param params
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:22
     */

    public static String httpPostRequestMap(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }
    /**
     * 描述:post请求，参数为Map，自定义header
     *
     * @param url
     * @param headers
     * @param params
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:22
     */

    public static String httpPostRequestMap(String url, Map<String, Object> headers, Map<String, Object> params)
            throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    /**
     * 描述:参数Map转换成键值对，供UrlEncodedFormEntity使用
     *
     * @param params
     * @return {@link ArrayList<org.apache.http.NameValuePair>}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:23
     */
    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }
        return pairs;
    }

    /**
     * 描述:处理HTTP请求
     *
     * @param request
     * @return {@link String}
     * @throws
     * @author ZQQ
     * @date 2020/4/14 9:24
     */
    private static String getResult(HttpRequestBase request) {
        //设置超时时间
        config(request);
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                String result = EntityUtils.toString(entity);
                response.close();
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EMPTY_STR;
    }

}


