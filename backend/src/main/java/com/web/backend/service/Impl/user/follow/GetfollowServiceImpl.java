package com.web.backend.service.Impl.user.follow;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.FollowMapper;
import com.web.backend.pojo.Follow;
import com.web.backend.service.user.follow.GetfollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetfollowServiceImpl implements GetfollowService {
    @Autowired
    private FollowMapper followMapper;
    @Override
    public List<Follow> getfollow(String userId) {
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return followMapper.selectList(queryWrapper);
    }
}
