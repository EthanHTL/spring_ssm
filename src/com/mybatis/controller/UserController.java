package com.mybatis.controller;


import com.mybatis.service.UserService;
import com.mybatis.vo.UserInfo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    @RequestMapping(value = "/addUser",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void addUser(UserInfo user,HttpServletResponse response) throws IOException {
        System.out.println("user="+user.toString());
        JSONObject json = new JSONObject();
        int i = userService.addUser(user);
        if(i==1) {
            json.put("code", 200);
            json.put("Msg", "成功！");
        }else {
            json.put("code", 400);
            json.put("Msg", "失败！");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json.toJSONString());
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
