package com.web.backend.service.Impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.UserMapper;
import com.web.backend.pojo.User;
import com.web.backend.service.user.account.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserlist() {
        return userMapper.selectList(null);
    }
}
