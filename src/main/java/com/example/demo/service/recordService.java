package com.example.demo.service;

import com.example.demo.domain.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class recordService {

    private JdbcTemplate jdbcTemplate;

    private  final static String sql = "insert into user (id,nickname,password) values (?,?,?)";




    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
