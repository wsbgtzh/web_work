package com.web.backend.service.Impl.user.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.UserMapper;
import com.web.backend.pojo.User;
import com.web.backend.service.user.utils.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, String> GetUserInfo(String userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = userMapper.selectById(userId);
        Map<String, String> map = new HashMap<>();
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("photo", user.getPhoto());
        map.put("follower_count", user.getFollowerCount().toString());
        return map;
    }
}
