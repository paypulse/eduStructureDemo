package com.example.edustructuredemo.MenuItem.controller;

import com.example.edustructuredemo.MenuItem.service.sampleService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(value="/edulab/menuItem")
public class sampleController {
    private static final Logger logger = LoggerFactory.getLogger(sampleController.class);

    //리소스 경로
    @Value("${file.location}")
    private String resourceFilePath;

    //로컬 리소스 다운 경로
    @Value("${file.local.storage}")
    private String localStroagePath;

    @Autowired
    ResourceLoader resourceLoader;

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
    public ResponseEntity<?>  downloadResource(HttpServletRequest req, HttpServletResponse res, @RequestParam String filename) throws Exception{

        String path = resourceFilePath + filename;

        try(InputStream in1 = new URL(path).openStream()){
            Resource toRes = new FileSystemResource(localStroagePath);
            Path target = Paths.get(localStroagePath);
            long result =  Files.copy(in1, target,StandardCopyOption.REPLACE_EXISTING);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return ResponseEntity.ok()
                .headers(headers)
                .body(Files.copy(in1, target,StandardCopyOption.REPLACE_EXISTING));
        }
    }

    /**
     * download to App sample
     * @param
     * @return resource
     * */
    @RequestMapping(value="/sampeDownload", method =RequestMethod.POST)
    public ResponseEntity sampleDownload(HttpServletRequest req, HttpServletResponse res, @RequestParam String filename) throws Exception{

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header", "header");
        String path = resourceFilePath + filename+".zip";


        return new ResponseEntity<Map<String,String>>(sample.sampleDownload(path,filename), httpHeaders, HttpStatus.OK);

    }





}
