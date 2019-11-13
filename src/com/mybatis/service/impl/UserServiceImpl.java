package com.mybatis.service.impl;

import com.mybatis.dao.UserDao;
import com.mybatis.mapper.userMapper;
import com.mybatis.service.UserService;
import com.mybatis.vo.UserInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


// 处理事务
@Service("userService")
public class UserServiceImpl implements UserService {

    //bean注入mapper
    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserInfo> findUserinfoByUsernameAndPassword(UserInfo userInfo) {
        System.out.println("=======service:"+userInfo);
        List<UserInfo> list = userDao.findUserinfoByUsernameAndPassword(userInfo);
        return list;
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userDao.addUser(userInfo);
    }

    @Override
    public int deleteUserBid(int id) {
        return userDao.deleteUserBid(id);
    }

    @Override
    public int updateUserBid(UserInfo userInfo) {
        return userDao.updateUserBid(userInfo);
    }

}
