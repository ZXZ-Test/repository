package com.example.SpringbootDemo.mongodb.dao;

import com.example.SpringbootDemo.mongodb.domain.User;

import java.util.List;

/**
 * 功能描述: 数据层操作类
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-16 16:36
 */
public interface UserDao {

    /**
     * 保存用户
     * @param user 返回保存的用户
     */
    public void saveUser(User user) ;

    /**
     * 根据名字查询用户
     * @param name 名字
     * @return 用户
     */
    public List<User> findUserByName(String name) ;

    /**
     * 更新用户
     * @param user 待更新的用户
     */
    public void updateUser(User user) ;

    /**
     * 根据MongoDB的_id删除用户
     * @param Id _id
     */
    public void deleteUserById(String Id) ;

}
