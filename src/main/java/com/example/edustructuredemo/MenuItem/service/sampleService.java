package com.example.edustructuredemo.MenuItem.service;

import org.springframework.core.io.Resource;

import java.net.MalformedURLException;
import java.util.Map;

public interface sampleService {

    /**
     * test service
     * @param
     * @return int
     * */
    int sampleCnt();


    /**
     * TEST RESOURCE DOWNLOAD
     * @param
     * @return resource File
     * */
    void resourceDownload();

    /**
     * sampel download api
     * @param
     * @return string
     * */
    Map<String,String> sampleDownload(String fileDirectory,String filename);



}
