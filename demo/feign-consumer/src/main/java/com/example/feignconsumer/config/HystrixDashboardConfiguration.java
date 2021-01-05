package com.example.feignconsumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HystrixDashboardConfiguration {
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //开机自启(加载顺序)
        registrationBean.addUrlMappings("/hystrix.stream");   //配置servlet的访问路径
        registrationBean.setName("HystrixMetricsStreamServlet");  //servlet的名称

        return registrationBean;
    }
}
