package com.example.demo.dao;


import com.example.demo.domain.Application;
import com.example.demo.domain.Data;
import com.example.demo.mapper.ApplicationMapper;
import com.example.demo.mapper.DataMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@RestController
public class AppDao {
    @Autowired
    ApplicationMapper appMapper;

    @GetMapping("/app/{id}")
    public String getAppById(@PathVariable("id") Integer id) {
        return appMapper.getAppById(id).toString();
    }

    @GetMapping("/app/stuNum/{id}")
    public Application getAppByNum(@PathVariable("id") String id) {
        return appMapper.getAppByNum(id);
    }


    @GetMapping("/app/getall")
    @MapKey("id")
    public Map<Integer, Application> getAllApp() {
        Map<Integer, Application> map = appMapper.getAllApp();
        System.out.println(map.toString());
        return map;
    }

    @GetMapping("/app/delete/{id}")
    public String delData(@PathVariable("id") Integer id) {
        appMapper.deleteAppById(id);
        return "删除成功";
    }

    @GetMapping("/app/insert")
    public String insertData(Application application) {
        appMapper.insertData(application);
        return "插入成功" + application.toString();
    }


}
