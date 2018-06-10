package com.example.demo.controller;

import com.example.demo.dao.AppDao;
import com.example.demo.domain.Application;
import com.example.demo.service.FileFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class GalleryController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AppDao appDao;

    @RequestMapping("/detail/{id}")
    public ModelAndView detailPage(@PathVariable("id") String id) {
        String mp4;
        String apk;
        Application app = appDao.getAppByNum(id);
        List ls = new ArrayList();
        FileFinder fileFinder = new FileFinder();
        System.out.println(fileFinder.getApkFile(id));
        System.out.println(fileFinder.getMp4File(id));
        System.out.println(fileFinder.getPicFile(id).toString());
        System.out.println(app.toString());


        ls = fileFinder.getPicFile(id);
        mp4 = fileFinder.getMp4File(id);
        apk = fileFinder.getApkFile(id);

        System.out.println(ls + mp4 + apk);

        ModelAndView mv = new ModelAndView("jsp/detail");
        mv.getModel().put("ls", ls);
        mv.getModel().put("mp4", mp4);
        mv.getModel().put("apk", apk);
        mv.getModel().put("app", app);

        return mv;
    }
/*    public ModelAndView upPage(@RequestParam("id") String id){
        ModelAndView mav = new ModelAndView("/jsp/detail");

//        String path = request.getSession().getServletContext().getRealPath("/save/");
        String path = "/save/";


        String video = path + id ;


        mav.getModel().put("video",video);

        return  mav;

    }*/




}
