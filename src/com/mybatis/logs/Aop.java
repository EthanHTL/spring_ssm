package com.mybatis.logs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Component 注入
 * @Aspect 切面
 * @author 海神阁
 */
@Component
@Aspect
public class Aop {

    @Pointcut("execution(* com.mybatis.service.impl.UserServiceImpl.findUserinfoByUsernameAndPassword(..))")
    public void findUser(){
    }


    @Before("findUser()")
    public void chaUser(){
        System.out.println("实现查询用户功能");
    }
}
