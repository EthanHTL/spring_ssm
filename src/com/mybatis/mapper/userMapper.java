package com.mybatis.mapper;

import com.mybatis.vo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


public interface userMapper {

    List<UserInfo> findUserinfoByUsernameAndPassword(UserInfo userInfo);

    int addUser(UserInfo userInfo);

    int deleteUserBid(int id);

    int updateUserBid(UserInfo userInfo);

    @Select("select * from user")
    List<UserInfo> finda();

}
