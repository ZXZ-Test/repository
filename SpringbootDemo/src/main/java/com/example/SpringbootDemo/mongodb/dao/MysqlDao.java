package com.example.SpringbootDemo.mongodb.dao;

import com.example.SpringbootDemo.mongodb.domain.MysqlDemo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能描述: Mysql 数据访问Dao
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-18 10:08
 */
@Mapper
@Component(value = "mysqlDao") //解决Service层 @AutoWire 提示错误
public interface MysqlDao {

    /**
     * 查询所有
     * @return all
     */
    List<MysqlDemo> queryAll();

}
