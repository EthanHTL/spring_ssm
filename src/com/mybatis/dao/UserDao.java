package com.mybatis.dao;

import com.mybatis.mapper.userMapper;
import com.mybatis.vo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDao implements userMapper {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<UserInfo> findUserinfoByUsernameAndPassword(@Param(value = "") UserInfo userInfo) {
        System.out.println("========Dao"+userInfo);
        return sqlSessionTemplate.selectList("com.mybatis.mapper.userMapper.findUserinfoByUsernameAndPassword");
    }

    @Override
    public int addUser(UserInfo userInfo) {
        System.out.println("=======Dao:"+userInfo);
        return sqlSessionTemplate.insert("com.mybatis.mapper.userMapper.addUser",userInfo);
    }

    @Override
    public int insertUsers(List<UserInfo> userInfos) {
        return sqlSessionTemplate.insert("com.mybatis.mapper.userMapper.insertUsers",userInfos);
    }

    @Override
    public int deleteUserBid(int id) {
        return sqlSessionTemplate.delete("com.mybatis.mapper.userMapper.deleteUserBid",id);
    }

    @Override
    public int updateUserBid(UserInfo userInfo) {
        return sqlSessionTemplate.update("com.mybatis.mapper.userMapper.updateUserBid");
    }

    @Override
    public List<UserInfo> finda() {
        return sqlSessionTemplate.selectList("com.mybatis.mapper.userMapper.finda");
    }


}
