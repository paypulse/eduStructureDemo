package com.example.edustructuredemo.MenuItem.domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface sampleDao {

    //test count
    public int selectCnt();
}
