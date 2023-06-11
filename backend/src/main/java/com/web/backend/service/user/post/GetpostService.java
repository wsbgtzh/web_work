package com.web.backend.service.user.post;

import com.web.backend.pojo.Post;

import java.util.List;
import java.util.Map;

public interface GetpostService {
    List<Post> getpost(int userId);
}
