package com.jn.springboot;

import com.jn.springboot.listener.MyListener;
import com.jn.springboot.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


    //将自定义的Servlet 添加到springboot 容器,当配置了urlmapping 后，selevlet 自己的配置就不会生效
    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){

        ServletRegistrationBean<MyServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(),"/jn2");

        servletServletRegistrationBean.setLoadOnStartup(1);

        return servletServletRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean<MyListener> getServletListenerRegistrationBean(){

        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());

        System.out.println(".............Listenering...........");

        return servletListenerRegistrationBean;

    }
}
