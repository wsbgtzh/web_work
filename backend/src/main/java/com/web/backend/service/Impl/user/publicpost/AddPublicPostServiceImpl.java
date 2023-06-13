package com.web.backend.service.Impl.user.publicpost;

import com.web.backend.mapper.PublicPostMapper;
import com.web.backend.pojo.Publicpost;
import com.web.backend.service.user.publicpost.AddPublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddPublicPostServiceImpl implements AddPublicPostService {
    @Autowired
    private PublicPostMapper postMapper;
    @Override
    public Map<String, String> addpublicpost(Integer user_id, String content, String username, String photo) {
        Publicpost post = new Publicpost(
                null,
                user_id,
                content,
                username,
                photo
        );
        postMapper.insert(post);
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        return map;
    }
}
