package com.example.demo.controller;

import com.example.demo.domain.Application;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
public class ManController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AppService appService;

    @RequestMapping("/manage.html")
    public ModelAndView ManPage() {
        ModelAndView mav = new ModelAndView("jsp/manage");
        return mav;
    }


    @RequestMapping("/blank")
    public ModelAndView BlkPage() {
        ModelAndView mav = new ModelAndView("jsp/blank");
        return mav;
    }

    @RequestMapping("/tables")
    public ModelAndView TablePage() {
        Map<Integer, Application> map = appService.getAllApp();

        ModelAndView mav = new ModelAndView("jsp/tables");
        mav.getModel().put("map", map);
        return mav;
    }

    @RequestMapping("/forms")
    public ModelAndView FormPage() {
        ModelAndView mav = new ModelAndView("jsp/forms");
        return mav;
    }


}
