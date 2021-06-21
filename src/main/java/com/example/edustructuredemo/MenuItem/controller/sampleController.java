package com.example.edustructuredemo.MenuItem.controller;

import com.example.edustructuredemo.MenuItem.service.sampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
public class sampleController {

    @Autowired
    private sampleService sampleService;


    public void setSampleService(sampleService sampleService){
        this.sampleService = sampleService;
    }


    /**
     * 구조 Test
     * @param
     * @return
     * */
    @GetMapping("/edulab/menuItem/cnt")
    public int sampleTest(HttpServletRequest req, HttpServletResponse res) throws Exception{

        return 0;
    }






}
