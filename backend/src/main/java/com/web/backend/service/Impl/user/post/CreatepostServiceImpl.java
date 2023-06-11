package com.web.backend.service.Impl.user.post;

import com.web.backend.mapper.PostMapper;
import com.web.backend.pojo.Post;
import com.web.backend.pojo.User;
import com.web.backend.service.Impl.utils.UserDetailsImpl;
import com.web.backend.service.user.post.CreatepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreatepostServiceImpl implements CreatepostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public Map<String, String> createPost(String content) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();
        Map<String, String> map = new HashMap<>();
        if (content == null) {
            map.put("error_message", "帖子不能为空");
            return map;
        }
        Post post = new Post(null, user.getId(), content);
        postMapper.insert(post);
        map.put("error_message", "success");
        return map;
    }
}
