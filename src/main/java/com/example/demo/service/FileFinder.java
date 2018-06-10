package com.example.demo.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileFinder {


    @RequestMapping("/getfile")
    public List getPicFile(@RequestParam("id") String id) {
        String path = "uploads/";
        path = path + id;
        File file = new File(path);
        File[] tempList = file.listFiles();
        List<String> picList = new ArrayList<>();
        String fileName;
        String check;

        for (File aTempList : tempList) {
            fileName = aTempList.getName();
            check = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            switch (check) {
                case "png":
                    picList.add(fileName);
                    break;
                case "jpg":
                    picList.add(fileName);
                    break;
                default:
                    break;
            }
        }
        return picList;
    }

    public String getMp4File(@RequestParam("id") String id) {
        String path = "uploads/";
        path = path + id;
        File file = new File(path);
        File[] tempList = file.listFiles();
        String mp4 = null;
        String fileName;
        String check;

        for (File aTempList : tempList) {
            fileName = aTempList.getName();
            check = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            switch (check) {
                case "mp4":
                    mp4 = fileName;
                    break;
                case "avi":
                    mp4 = fileName;
                    break;
                default:
                    break;
            }
        }
        return mp4;

    }

    public String getApkFile(@RequestParam("id") String id) {
        String path = "uploads/";
        path = path + id;
        File file = new File(path);
        File[] tempList = file.listFiles();
        String apk = null;
        String fileName;
        String check;
        for (File aTempList : tempList) {
            fileName = aTempList.getName();
            check = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            switch (check) {
                case "apk":
                    apk = fileName;
                    break;
                default:
                    break;
            }
        }
        System.out.println(apk);
        return apk;

    }


}
