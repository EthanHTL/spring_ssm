package com.mybatis.test;

import com.mybatis.service.UserService;
import com.mybatis.vo.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TestSsm{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService  u = (UserService) context.getBean("userService");

//        List<UserInfo> userInfoList = u.findUserinfoByUsernameAndPassword(new UserInfo("q","q","男"));
//        for (UserInfo user: userInfoList
//        ) {
//            System.out.println(user.toString());
//
//        }
        List<UserInfo> userInfoList = u.finda();
        for (UserInfo user: userInfoList
        ) {
            System.out.println(user.toString());

        }
    }

    /**
     * 批量插入用户
     */
    @Test
    public void insertUsers(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService  u = (UserService) context.getBean("userService");

        List<UserInfo> userInfos = new ArrayList<>();

        for(int i=0;i<950;i++){

            String name = UUID.randomUUID().toString().replaceAll("-", "").substring(0,5);
            String pass = UUID.randomUUID().toString().replaceAll("-", "").substring(5,12);
            String[] sex = {"男","女"};
            Random random = new Random();
            int f = random.nextInt(2);
            UserInfo user = new UserInfo(name,pass,sex[f]);
            userInfos.add(user);
        }

        int j = u.insertUsers(userInfos);
        System.out.println("i = "+j);

    }

}
