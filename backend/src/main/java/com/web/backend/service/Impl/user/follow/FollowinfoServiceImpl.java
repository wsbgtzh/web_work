package com.web.backend.service.Impl.user.follow;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.FollowMapper;
import com.web.backend.pojo.Follow;
import com.web.backend.service.user.follow.FollowinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FollowinfoServiceImpl implements FollowinfoService {
    @Autowired
    private FollowMapper followMapper;
    @Override
    public Map<String, String> followinfo(Integer userId, Integer targetId) {
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("target_id", targetId);
        Follow follow = followMapper.selectOne(queryWrapper);
        if (follow == null) {
            Follow f = new Follow(
                    null,
                    userId,
                    targetId,
                    false
            );
            followMapper.insert(f);
            follow = f;
        }
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("followed", follow.getFollowed().toString());
        map.put("follow_id", follow.getId().toString());
        return map;
    }
}
