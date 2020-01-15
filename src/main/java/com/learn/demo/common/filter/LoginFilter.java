package com.learn.demo.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.learn.demo.common.enums.ResultCode;
import com.learn.demo.common.response.ResponseResult;
import com.learn.demo.common.utils.UriUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {


    private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    private final static String MEDIA_TYPE = "application/json;charset=UTF-8";
    private String[] excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludeUrl = filterConfig.getInitParameter("excludeUrl");
        if (!StringUtils.isEmpty(excludeUrl)) {
            excludeUrls = excludeUrl.split(",");
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String userName = (String) httpServletRequest.getSession().getAttribute("userName");
        String uri = httpServletRequest.getRequestURI();
        if (UriUtils.isInclude(uri, excludeUrls)) {
            chain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (StringUtils.isEmpty(userName)) {
            ResponseResult<String> responseResult = new ResponseResult<>(ResultCode.FAIL_CODE, "用户未登陆", null);
            String resultJson = JSONObject.toJSONString(responseResult);
            httpServletResponse.setContentType(MEDIA_TYPE);
            httpServletResponse.getWriter().write(resultJson);
            logger.info("用户未登陆");
            return;
        }
        chain.doFilter(httpServletRequest, httpServletResponse);
        return;
    }


    @Override
    public void destroy() {

    }
}
