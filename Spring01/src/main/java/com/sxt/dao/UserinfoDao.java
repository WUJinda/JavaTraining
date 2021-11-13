package com.sxt.dao;

import com.sxt.po.Userinfo;
import org.springframework.stereotype.Repository;

/**
 * dao层 （数据访问层， 数据库的增删改查操作）
 *
 */
@Repository
public class UserinfoDao {

    // 假设用户名和密码
    private final String USER_NAME = "admin";
    private final String USER_PWD = "123456";

    /**
     *
     * @param userName
     * @return
     */

    public Userinfo queryUserByNmae(String userName){
        Userinfo userinfo = null;
        // 判断用户名是否正确
        if (USER_NAME.equals(userName)){

            userinfo = new Userinfo();
            userinfo.setUserId(1);
            userinfo.setUserName(userName);
            userinfo.setUserPwd(USER_PWD);
        }
        return userinfo;
    }
}
