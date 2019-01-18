package com.example.SpringbootDemo.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 功能描述: MongoDB User 实体类
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-16 16:34
 */
@SuppressWarnings("serail")
@Document(collection = "runoob") //指定实体对应MongoDB的哪一个集合
public class User implements Serializable {

    @Id
    private String id;

    @Field
    private String testName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String name) {
        this.testName = name;
    }
}
