package com.jn.springboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class MyListener implements HttpSessionListener {

    public  static  int online = 0;


    @Override
    public void sessionCreated(HttpSessionEvent se) {


        System.out.println("......创建Session.........");

        online++;
    }


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
