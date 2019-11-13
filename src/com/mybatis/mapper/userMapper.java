package com.mybatis.mapper;

import com.mybatis.vo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userMapper {

    List<UserInfo> findUserinfoByUsernameAndPassword(UserInfo userInfo);

    int addUser(UserInfo userInfo);

    int deleteUserBid(int id);

    int updateUserBid(UserInfo userInfo);

}
