package com.example.demo.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.domain.Data;
import com.example.demo.domain.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class DataDao {
	private JdbcTemplate jdbcTemplate;


	private  final static String MATCH_DATA_SQL = "SELECT (*) FROM data";


	public List getAll(){

		List rows = jdbcTemplate.queryForList("SELECT * FROM data");
		return rows;
	}


	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
