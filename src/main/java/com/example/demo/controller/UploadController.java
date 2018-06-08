package com.example.demo.controller;

import com.example.demo.service.unZipFiles;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.IOException;
import java.util.List;

/**
 * 暂时废弃
 */

@RestController
public class UploadController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/up")
    public ModelAndView upfile(){
        ModelAndView mav = new ModelAndView("jsp/fileupload.html");

        return mav;
    }


    @RequestMapping("/upload11")
    public String hello(){
        System.out.println("hello");
        return "0";
    }


@RequestMapping(value = {"/upload"}, produces = {"application/json;charset=UTF-8"})
//@RequestMapping("/upload")
@ResponseBody
public String upload(@RequestParam("uploadFile") MultipartFile[] uploadFile) {
    JSONObject bb = new JSONObject();
    System.out.println("进入");
    bb.put("Status", "Success");
    System.out.println(uploadFile.length);
    if (uploadFile.length > 0 && uploadFile != null) {
        try {
            String leftPath = this.request.getSession().getServletContext().getRealPath("save/");
            MultipartFile[] var4 = uploadFile;
            int var5 = uploadFile.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                MultipartFile file = var4[var6];
                file.transferTo(new File(leftPath + file.getOriginalFilename()));

                try {
                    unZipFiles.unZipFiles(new File(leftPath + file.getOriginalFilename()), "D:/data/");
                    System.out.println("上传并且解压成功");
                } catch (IOException var9) {
                    var9.printStackTrace();
                }
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }
    }

    return bb.toString();
}

    @RequestMapping("list")
    public ModelAndView list(){
        String filePath = request.getSession().getServletContext().getRealPath("/");
        ModelAndView mav = new ModelAndView("list");

//        初始化文件列表
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        int len = fileNames.length;


        mav.getModel().put("fileNames",fileNames);
        mav.getModel().put("len",len);
        return mav;
    }
}
