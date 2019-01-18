package com.example.SpringbootDemo.mongodb.controller;

import com.example.SpringbootDemo.mongodb.domain.MysqlDemo;
import com.example.SpringbootDemo.mongodb.domain.User;
import com.example.SpringbootDemo.mongodb.service.IUserService;
import com.example.SpringbootDemo.mongodb.service.impl.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述: 测试控制类-提供浏览器访问
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-17 15:51
 */
@RestController
public class SpringBootTestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private MySQLService mySQLService;

    /**
     * MongoDB 拉取集合所有数据
     * @return 返回所有集合信息
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    /**
     * MongoDB 根据对应key值拉取集合数据
     * @return 返回对应集合信息
     */
    @RequestMapping("/find/{testName}")
    public String find(@PathVariable("testName") String testName){
        List<User> users = userService.findUserByName(testName);
        String str = "";
        for (User user : users){
            str += "\n" + user.getId() + user.getTestName();
        }
        return "find success..." + "\n" + str;
    }

    /**
     * MongoDB 新增集合数据
     */
    @RequestMapping("/save/{testName}")
    public String insert(@PathVariable("testName") String testName){
        User user = new User();
        user.setTestName(testName);
        userService.saveUser(user);
        return "save success...";
    }

    /**
     * MySQL 拉取测试表所有数据
     * @return 测试表所有数据
     */
    @RequestMapping("/queryAll")
    public List<MysqlDemo> queryAll(){
        List<MysqlDemo> results = mySQLService.queryAll();
        return results;
    }
}
