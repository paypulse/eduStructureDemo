package com.example.edustructuredemo.MenuItem.serviceImpl;


import com.example.edustructuredemo.MenuItem.service.sampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edustructuredemo.MenuItem.domain.sampleDao;


import javax.transaction.Transactional;

@Transactional
@Service
public class sampleServiceImpl implements sampleService {

    @Autowired
    private sampleDao sample;

    /**
     * 구조 sample
     * */
    @Override
    public int sampleCnt() {
        System.out.println(sample.selectCnt());
        return sample.selectCnt() ;
    }

    /**
     * TEST RESOURCE DOWNLOAD
     * @param
     * @return resource File
     * */
    @Override
    public void resourceDownload() {

    }


}
