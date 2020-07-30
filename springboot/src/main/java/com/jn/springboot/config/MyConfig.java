package com.jn.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义视图解析器
 */


@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/sss").setViewName("hello");
        //针对定义的请求，转发到对应的视图解析器
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

    }


    @Bean
    public LocaleResolver localeResolver() {
        return new NativeLocaleResolver();
    }


    private class NativeLocaleResolver implements LocaleResolver {
        @Override
        public Locale resolveLocale(HttpServletRequest httpServletRequest) {

            String language = httpServletRequest.getParameter("language");

            Locale locale = Locale.getDefault();

            if (!StringUtils.isEmpty(language)) {
                if (!locale.equals(language)) {
                    String[] split = language.split("_");
                    //   login_zh_CN.properties  login_en_US.properties
                    locale = new Locale(split[0], split[1]);
                }
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

        }
    }
}
