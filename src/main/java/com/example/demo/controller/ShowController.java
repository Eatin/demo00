package com.example.demo.controller;

import com.example.demo.domain.Data;
import com.example.demo.domain.Usr;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ShowController {
    private DataService DataService;

    /*    @CrossOrigin(origins = "*", maxAge = 3600)*/
    @RequestMapping(value = "/main")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("jsp/main");
        List<Data> list = DataService.getData();
        mav.getModel().put("list",list);

        return mav;
    }



    @Autowired
    public void setDataService(DataService DataService) {
        this.DataService = DataService;
    }
}
