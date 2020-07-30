package com.jn.springboot_data.druid;

import com.jn.springboot_data.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class DataSourceController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("local")
    @DataSource(value = DataSourceType.LOCAL)
    public List<Map<String, Object>> local() {

        String sql = "select  *  from  person ";

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        return mapList;
    }


    @RequestMapping("remove")
    @DataSource(value = DataSourceType.REMOVE)
    public List<Map<String, Object>> remove() {

        String sql = "select  *  from  person ";

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        return mapList;
    }
}
