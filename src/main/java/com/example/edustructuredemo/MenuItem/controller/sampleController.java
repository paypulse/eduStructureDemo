package com.example.edustructuredemo.MenuItem.controller;

import com.example.edustructuredemo.MenuItem.service.sampleService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Slf4j
@RestController
@RequestMapping(value="/edulab/menuItem")
public class sampleController {
    private static final Logger logger = LoggerFactory.getLogger(sampleController.class);

    //리소스 경로
    private static final String resourceFilePath = "http://211.34.230.55/atest/";

    //출력 파일 경로
   // private static final String outputFilePath = "/data/user/";

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
    public void  downloadResource(HttpServletRequest req, HttpServletResponse res, @RequestParam String filename) throws Exception{

        String str = resourceFilePath +filename;
        Path path = Paths.get(str);

        ZipOutputStream zipOut = new ZipOutputStream(res.getOutputStream());
        FileSystemResource resource = new FileSystemResource(path.toString());
        ZipEntry zipEntry = new ZipEntry(resource.getFilename());
        zipEntry.setSize(resource.contentLength());
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(resource.getInputStream(), zipOut);
        zipOut.closeEntry();

        zipOut.finish();
        zipOut.close();
        res.setStatus(HttpServletResponse.SC_OK);
        res.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

    }



}
