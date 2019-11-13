package com.mybatis.service;

import com.mybatis.vo.UserInfo;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;


// 处理事务
public interface UserService {

    List<UserInfo> findUserinfoByUsernameAndPassword(UserInfo userInfo);

    int addUser(UserInfo userInfo);

    int deleteUserBid(int id);

    int updateUserBid(UserInfo userInfo);
}
