package com.example.demo.dao;


import com.example.demo.domain.Data;
import com.example.demo.mapper.DataMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    DataMapper dataMapper;

    @GetMapping("/data/{id}")
    public Data getData(@PathVariable("id") Integer id){
        return dataMapper.getDataById(id);
    }

    @GetMapping("/data")
    public Data insertData(Data data){
        dataMapper.insertData(data);
        return data;
    }


}
