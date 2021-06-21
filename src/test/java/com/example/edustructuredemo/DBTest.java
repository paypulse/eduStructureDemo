package com.example.edustructuredemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DBTest {
        @Autowired
        DataSource dataSource;

        @Test
        public void connection() throws SQLException{

            try(Connection connection = dataSource.getConnection()){
                System.out.println("***********************************");
                log.info("***************************************************");
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("com/example/edustructuredemo/test");
                log.info("url:" + metaData.getURL());
                log.info("Driver Name :" + metaData.getDriverName());
                log.info("User Name :" + metaData.getUserName());
                log.info("***************************************************");
            }
        }

}
