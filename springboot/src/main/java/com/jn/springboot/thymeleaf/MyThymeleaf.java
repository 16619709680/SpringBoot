package com.jn.springboot.thymeleaf;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 引擎模板测试类
 */

@Controller
public class MyThymeleaf {

    @RequestMapping("thymeleaftest")
    public String thymeleaftest(ModelMap map) {

        map.put("Str", "Blog");
        map.put("Bool", true);
        map.put("Array", new Integer[]{1, 2, 3, 4});
        map.put("List", Arrays.asList(1, 3, 2, 4, 0));
        Map hashMap = new HashMap();
        hashMap.put("thName", "${#...}");
        hashMap.put("desc", "变量表达式内置方法");
        map.put("Map", hashMap);
        map.put("Date", new Date());
        map.put("Num", 888.888D);


        return "thymeLeaf_1";

    }
}
