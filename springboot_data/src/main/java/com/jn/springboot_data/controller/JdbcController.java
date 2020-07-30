package com.jn.springboot_data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("queryPerson")
    public List<Map<String, Object>> queryPerson() {

        String sql = "select  *  from  person ";

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        return mapList;
    }


    @RequestMapping("joinPerson")
    public String joinPerson() {

        String sql = "insert into person(name,age,sex) values ('吕小布',21,'男')";

        int update = jdbcTemplate.update(sql);

        System.out.println(update);

        return "Join Success";
    }

    @RequestMapping("updatePerson/{personName}")
    public String updatePerson(@PathVariable("personName") String personName) {

        String sql = "update person set sex = ? where name ='" + personName + "'";

        String sex = "女";

        int update = jdbcTemplate.update(sql, sex);

        System.out.println(update);

        return "Update Success";
    }


    @RequestMapping("deletePerson/{sex}")
    public String deletePerson(@PathVariable("sex") String sex) {

        String sql = "delete from  person where sex = '" + sex + "' ";

        int update = jdbcTemplate.update(sql);

        System.out.println(update);

        return "Delete Success";
    }

}
