package com.mybatis.test;

import com.mybatis.service.UserService;
import com.mybatis.vo.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService  u = (UserService) context.getBean("userService");

        List<UserInfo> userInfoList = u.findUserinfoByUsernameAndPassword(new UserInfo("q","q","男"));
        for (UserInfo user: userInfoList
        ) {
            System.out.println(user.toString());

        }
    }
//    @Test
//    public test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//
//        UserService  u = (UserService) context.getBean("userService");
//
//        List<UserInfo> userInfoList = u.findUserinfoByUsernameAndPassword(new UserInfo("q","q","男"));
//        for (UserInfo user: userInfoList
//             ) {
//            System.out.println(user.toString());
//
//        }
//
////        u.addUser(new UserInfo("q","q","女"));
//
//
//    }
}