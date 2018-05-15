package ssm.entity;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2018
 * Company: UD
 * @author Uncle Drew
 * @version 1.0 2018/5/15 11:23
 */
@SuppressWarnings("serial")
public class SsmEntityVO implements Serializable {

    /** 用户ID **/
    private Long userId;
    /** 用户名称 **/
    private String userName;
    /** 用户密码 **/
    private String userPwd;
    /** 用户编号 **/
    private String userCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
