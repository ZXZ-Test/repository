package com.example.SpringbootDemo.mongodb.service.impl;

import com.example.SpringbootDemo.mongodb.domain.User;
import com.example.SpringbootDemo.mongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: MongoDB 数据操作Service 接口实现
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-16 16:50
 */
@Service("userService")//可以不用给定value,看个人习惯
public class UserServiceImpl implements IUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户
     * @param user 返回保存的用户
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    /**
     * 根据名字查询用户
     * @param name 名字
     * @return 用户
     */
    public List<User> findUserByName(String name) {
        Query query = new Query(Criteria.where("testName").is(name));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

}
