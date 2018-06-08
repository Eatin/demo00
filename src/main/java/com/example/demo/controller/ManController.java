package com.example.demo.controller;

import com.example.demo.dao.DataDao;
import com.example.demo.domain.Usr;
import com.example.demo.service.recordService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class ManController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/manage.html")
    public ModelAndView ManPage(){
        ModelAndView mav = new ModelAndView("jsp/manage");
        return mav;
    }


    @RequestMapping("/blank")
    public ModelAndView BlkPage(){
        ModelAndView mav = new ModelAndView("jsp/blank");
        return mav;
    }

    @RequestMapping("/tables")
    public ModelAndView TablePage(){
        ModelAndView mav = new ModelAndView("jsp/tables");
        return mav;
    }


}
