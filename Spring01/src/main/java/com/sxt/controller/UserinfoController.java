package com.sxt.controller;

import com.sxt.model.Resultinfo;
import com.sxt.service.UserinfoService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserinfoController {

    @Resource
    private UserinfoService userinfoService;

    /**
     *
     *         1.接受参数，（用户名，密码）
     *         2.调用业务逻辑层对应的方法，得到登录结果（result对象），
     *         3.响应结果
     * @param uname
     * @param upwd
     * @return
     */
    public Resultinfo userLogin(String uname, String upwd){

        Resultinfo resultinfo = userinfoService.userLogin(uname,upwd);

        return resultinfo;
    }
}
