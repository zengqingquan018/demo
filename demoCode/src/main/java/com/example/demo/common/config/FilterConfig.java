package com.example.demo.common.config;

import com.example.demo.common.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;


@Configuration
public class FilterConfig {
    @Value("${excludeUrl}")
    private String excludeUrl;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        LoginFilter loginFilter = new LoginFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(loginFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addInitParameter("excludeUrl", excludeUrl);
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistrationBean;
    }
}
