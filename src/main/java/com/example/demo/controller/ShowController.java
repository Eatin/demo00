package com.example.demo.controller;

import com.example.demo.dao.AppDao;
import com.example.demo.domain.Application;
import com.example.demo.domain.Data;
import com.example.demo.domain.Usr;
import com.example.demo.service.AppService;
import com.example.demo.service.DataService;
import com.example.demo.service.FileFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class ShowController {
    private DataService DataService;

    @Autowired
    private AppService appService;

    @Autowired
    private AppDao appDao;
    /*    @CrossOrigin(origins = "*", maxAge = 3600)*/
    @RequestMapping(value = "/main")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("jsp/main");
        Map<Integer, Application> map = appDao.getAllApp();
        System.out.println(map.toString());
        mav.getModel().put("map", map);

        return mav;
    }



    @Autowired
    public void setDataService(DataService DataService) {
        this.DataService = DataService;
    }
}
