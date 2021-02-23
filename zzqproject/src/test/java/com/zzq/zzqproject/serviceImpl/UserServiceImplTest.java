package com.zzq.zzqproject.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzq.zzqproject.ZzqprojectApplication;
import com.zzq.zzqproject.entity.User;
import com.zzq.zzqproject.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest("ZzqprojectApplication.class")
class UserServiceImplTest {
   @Resource
   public UserMapper userMapper;

    @Test
    void getUserByUsernameAndPassword() {
        String username="zzq";
        String password="zzq123";
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("username",username).eq("password",password);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }
}