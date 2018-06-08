package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
public class DownloadController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/download")

    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("downloadFile")String downloadFile) throws IOException {
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/save/" + downloadFile);
        String p3=request.getContextPath();
        System.out.println(p3);
        System.out.print("路径" + realPath);

        InputStream in = new FileInputStream(new File(realPath));

        byte[] body = null ;
        body = new byte[in.available()] ;

        in.read(body);

        String fileName = new String(downloadFile.getBytes("gbk"),"iso8859-1") ;

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition","attachment ; filename = " + fileName );

        HttpStatus statusCode = HttpStatus.OK ;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body , headers ,statusCode);

        return  response;


    }

}
