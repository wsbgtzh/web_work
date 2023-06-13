package com.web.backend.service.Impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.UserMapper;
import com.web.backend.pojo.User;
import com.web.backend.service.user.account.UpdateinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdeinfoServiceImpl implements UpdateinfoService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, String> updateinfo(String user_id, String followerCount) {
        Map<String, String> map = new HashMap<>();
        User user = userMapper.selectById(user_id);
        User new_user = new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoto(),
                Integer.parseInt(followerCount)
        );
        userMapper.updateById(new_user);
        map.put("error_message", "success");
        return map;
    }
}
