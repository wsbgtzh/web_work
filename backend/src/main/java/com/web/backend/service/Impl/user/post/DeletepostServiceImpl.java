package com.web.backend.service.Impl.user.post;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.PostMapper;
import com.web.backend.pojo.Post;
import com.web.backend.service.user.post.DeletepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeletepostServiceImpl implements DeletepostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public Map<String, String> deletepost(int id) {
        Map<String, String> map = new HashMap<>();
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        postMapper.delete(queryWrapper);
        map.put("error_message", "success");
        return map;
    }
}
