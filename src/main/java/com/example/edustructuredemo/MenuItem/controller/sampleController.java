package com.example.edustructuredemo.MenuItem.controller;

import com.example.edustructuredemo.MenuItem.service.sampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class sampleController {

    /*service*/
    private sampleService sampleService;

    @Autowired
    public void setSampleService(sampleService sampleService){
        this.sampleService = sampleService;
    }


    /**
     * 구조 Test
     * @param
     * @return
     * */






}
