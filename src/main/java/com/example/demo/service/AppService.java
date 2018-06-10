package com.example.demo.service;

import com.example.demo.dao.AppDao;
import com.example.demo.domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppService {
    private AppDao appDao;


    public Map<Integer, Application> getAllApp() {
        List ls;
        Map<Integer, Application> map;
        map = appDao.getAllApp();
        return map;

    }


    @Autowired
    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

}
