package com.web.backend.controller.user.post;

import com.web.backend.pojo.Post;
import com.web.backend.service.user.post.GetpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetpostController {
    @Autowired
    private GetpostService getpostService;
    @GetMapping("/user/postlist/")
    public List<Post>getpost(@RequestParam Map<String, String> map) {
        String userId = map.get("user_id");
        return getpostService.getpost(Integer.parseInt(userId));
    }
}
