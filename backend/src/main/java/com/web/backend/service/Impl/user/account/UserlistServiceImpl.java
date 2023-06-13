package com.web.backend.service.Impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.FollowMapper;
import com.web.backend.mapper.UserMapper;
import com.web.backend.pojo.Follow;
import com.web.backend.pojo.User;
import com.web.backend.service.user.account.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FollowMapper followMapper;
    @Override
    public List<User> getUserlist(String user_id) {
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id);
        List<Follow> list = followMapper.selectList(queryWrapper);
        List<User> list1 = new LinkedList<>();
        for (Follow x : list) {
            if (x.getFollowed())
                list1.add(userMapper.selectById(x.getTargetId()));
        }
        return list1;
    }
}
