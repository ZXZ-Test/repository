package com.example.SpringbootDemo.mongodb.service.impl;

import com.example.SpringbootDemo.mongodb.dao.MysqlDao;
import com.example.SpringbootDemo.mongodb.domain.MysqlDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: Mysql 数据访问 Service
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-18 10:11
 */
@Service
public class MySQLService {

    @Autowired
    private MysqlDao mysqlDao;

    public List<MysqlDemo> queryAll() throws RuntimeException{
        return mysqlDao.queryAll();
    }

}
