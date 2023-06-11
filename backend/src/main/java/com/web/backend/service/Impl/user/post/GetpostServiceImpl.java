package com.web.backend.service.Impl.user.post;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.PostMapper;
import com.web.backend.pojo.Post;
import com.web.backend.service.user.post.GetpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetpostServiceImpl implements GetpostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public List<Post> getpost(int userId) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return postMapper.selectList(queryWrapper);
    }
}
