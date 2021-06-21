package com.example.edustructuredemo.MenuItem.serviceImpl;


import com.example.edustructuredemo.MenuItem.service.sampleService;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;

@Transactional
@Service
public class sampleServiceImpl implements sampleService {


    /**
     * 구조 sample
     * */
    @Override
    public int sampleCnt() {
        return 0 ;
    }



}
