package com.example.SpringbootDemo.mongodb.domain;

import java.io.Serializable;

/**
 * 功能描述: MySQL 数据测试实体类
 * Copyright: Copyright (c) 2018
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-18 10:04
 */
@SuppressWarnings("serial")
public class MysqlDemo implements Serializable {

    private Long sysStockDetailId;

    private String remark;

    public Long getSysStockDetailId() {
        return sysStockDetailId;
    }

    public void setSysStockDetailId(Long sysStockDetailId) {
        this.sysStockDetailId = sysStockDetailId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
