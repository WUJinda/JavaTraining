package com.sxt.service;


import com.sxt.dao.UserinfoDao;
import com.sxt.model.Resultinfo;
import com.sxt.po.Userinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserinfoService {

    @Resource
    private UserinfoDao userinfoDao;

    /**
     *
     *          1.参数判断，（判断参数是否为空，如果为空，设置Resultinfo对象，并返回；不为空，调用dao查询方法）
     *         2.调用Dao层的查询方法，通过用户名查询用户记录，返回用户对象
     *         3.判断用户对象是否为空
     *             如果用户对象为空，设置Resultinfo对象，并返回
     *         4.判断密码是否正确（判断客户端传递的密码与数据库中查询的密码是否相等）
     *             如果不相等，设置Resultinfo对象，并返回
     *         5.登录成功，设置Resultinfo对象，并返回
     * @param uname
     * @param upwd
     * @return
     */
    public Resultinfo userLogin(String uname, String upwd){
        Resultinfo resultinfo = new Resultinfo();
        // 1.参数判断，
        if (isEmpty(uname) || isEmpty(upwd)){
            resultinfo.setCode(500);
            resultinfo.setMsg("用户名，密码不能为空");
            return resultinfo;
        }
        //2.调用Dao层的查询方法，通过用户名查询用户记录，返回用户对象
        Userinfo userinfo = userinfoDao.queryUserByNmae(uname);
        //3.判断用户对象是否为空
        if (userinfo == null){
            resultinfo.setCode(500);
            resultinfo.setMsg("用户名不存在");
            return resultinfo;
        }
        //4.判断密码是否正确（判断客户端传递的密码与数据库中查询的密码是否相等）
        if (!upwd.equals(userinfo.getUserPwd())){
            resultinfo.setCode(500);
            resultinfo.setMsg("用户密码不存在");
            return resultinfo;
        }
        //5.登录成功，设置Resultinfo对象，并返回
        resultinfo.setCode(200);
        resultinfo.setMsg("登录成功");


        return resultinfo;

    }

    /**
     *
     * 判断字符串是否为空，为空返回true，不为空返回false
     * @param str
     * @return
     */
    public Boolean isEmpty(String str){

        if (str == null || "".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }
}
