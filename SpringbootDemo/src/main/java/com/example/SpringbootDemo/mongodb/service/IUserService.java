package com.example.SpringbootDemo.mongodb.service;

import com.example.SpringbootDemo.mongodb.domain.User;

import java.util.List;

/**
 * 功能描述: MongoDB数据操作Service 接口
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-16 16:48
 */
public interface IUserService {
    /**
     * 保存用户
     * @param user 返回保存的用户
     */
    void saveUser(User user) ;


    /**
     * 查询所有用户
     * @return 用户
     */
    List<User> findAll() ;

    /**
     * 根据名字查询用户
     * @param name 名字
     * @return 用户
     */
    List<User> findUserByName(String name) ;
}
