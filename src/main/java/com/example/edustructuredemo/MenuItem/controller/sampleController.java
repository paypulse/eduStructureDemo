package com.example.edustructuredemo.MenuItem.controller;

import com.example.edustructuredemo.MenuItem.service.sampleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipOutputStream;


@Slf4j
@RestController
@RequestMapping(value="/edulab/menuItem")
public class sampleController {
    private static final Logger logger = LoggerFactory.getLogger(sampleController.class);

    //file path
    private static final String External_fila_path = "https://file.total-system.co.kr/atest/";

    @Autowired
    private sampleService sample;



    /**
     * 구조 Test
     * @param
     * @return
     * */
    @RequestMapping(value="/cnt", method = RequestMethod.GET)
    public int sampleTest(HttpServletRequest req, HttpServletResponse res) throws Exception{

        return sample.sampleCnt();
    }

    /**
     * download to App sample
     * @param
     * @return resource
     * */
    @RequestMapping(value="/download", method =RequestMethod.POST)
    public void downloadResource(HttpServletRequest req, HttpServletResponse res) throws Exception{


        //log.info(file.getName().toString());

       // String mimeType = URLConnection.guessContentTypeFromName(file.getName());
       // res.setContentType(mimeType);
       // res.setHeader("Content-Disposition",String.format("inline; filename=\"" + file.getName() +"\""));
      //  res.setContentLength((int) file.length());
        //InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //log.info(inputStream.toString());
    }







}
