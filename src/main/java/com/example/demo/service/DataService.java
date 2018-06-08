package com.example.demo.service;

import com.example.demo.dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
	private DataDao DataDao;


	public List getData(){
		List ls;
		ls = DataDao.getAll();
		return  ls;
	}


	@Autowired
	public void setDataDao(DataDao DataDao) {
		this.DataDao = DataDao;
	}

}
