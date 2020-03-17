package com.example.demo.common.utils;

import org.springframework.util.AntPathMatcher;

/**
 * @Author ZQQ
 * @Date 2020/1/5 9:59
 */
public class UriUtils {
    /**
     * 判断url是否包含在某个数组中
     *
     * @param uri
     * @param uris
     * @return java.lang.Boolean
     * @author ZQQ
     * @date 2020/1/5
     */
    public static Boolean isInclude(String uri, String[] uris) {
        Boolean sign = false;
        if (null == uris) {
            return false;
        }
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String s : uris) {
            if (antPathMatcher.match(s, uri)) {
                sign = true;
                break;
            }
        }
        return sign;
    }
}
