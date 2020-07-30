package com.jn.springboot.controller;


import com.jn.springboot.listener.MyListener;
import com.jn.springboot.scope.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @RequestMapping("/hi")
    public  String back(){

        return "hello,Springboot!";

    }


    /**监听器*/
    @RequestMapping("/online")
    public String  online(HttpSession session){

        session.setAttribute("S","SSS");

        return "当前在线人数："+ MyListener.online;
    }

    /**视图解析器*/
    @RequestMapping("/config")
    public  String config(){

        return "hello";

    }

    /**模板引擎*/
    @RequestMapping("/thymeleaf")
    public  String thymeleaf(ModelMap model,HttpSession   httpSession){

       /* model.addAttribute("msg","What's you name?");
        return "hello";*/

       httpSession.setAttribute("name","赵子龙");


        model.put("thText","th:text设置文本内容 <b>加粗</b>");
        model.put("thUText","th:utext 设置文本内容 <b>加粗</b>");
        model.put(" ","thValue 设置当前元素的value值");
        model.put("thEach","Arrays.asList(\"th:each\", \"遍历列表\")");
        model.put("thIf","msg is not null");
        model.put("thObject",new Person("zhangsan",12,"男"));


        return "thymeleaf";
    }


    /**模板引擎*/
    @RequestMapping("/login")
    public  String login(ModelMap model,HttpSession   httpSession){


        return "login";
    }
}
