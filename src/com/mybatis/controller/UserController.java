package com.mybatis.controller;


import com.mybatis.service.UserService;
import com.mybatis.vo.UserInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {

    //注入业务对象( 通过bean注入
    @Resource
    @Qualifier("userService")
    private UserService userService;

    /**
     * 跳转到index.jsp
     */
    @RequestMapping("/input")
    public String input(){
        return "input";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(UserInfo userInfo){
        int i = userService.addUser(userInfo);
        if (i>0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/show")
    public String show(Model model){
        List<UserInfo> userInfos = userService.findUserinfoByUsernameAndPassword(new UserInfo("q","q","男"));
        if (userInfos != null){
            for (UserInfo user: userInfos) {
                System.out.println(user.toString());
            }
        }else {
            System.out.println("没有用户");
        }
        model.addAttribute("userList",userInfos);
        return "showUser";
    }


}
