package com.web.backend.service.Impl.user.follow;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.FollowMapper;
import com.web.backend.pojo.Follow;
import com.web.backend.service.user.follow.UpdatefollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UpdatefollowServiceImpl implements UpdatefollowService {
    @Autowired
    private FollowMapper followMapper;
    @Override
    public Map<String, String> updatefollow(String followId, String followed) {
        Follow follow = followMapper.selectById(followId);
        Follow new_follow = new Follow(
                follow.getId(),
                follow.getUserId(),
                follow.getTargetId(),
                Boolean.parseBoolean(followed)
        );
        followMapper.updateById(new_follow);
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        return map;
    }
}
