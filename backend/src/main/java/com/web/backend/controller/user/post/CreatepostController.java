package com.web.backend.controller.user.post;

import com.web.backend.service.user.post.CreatepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreatepostController {
    @Autowired
    private CreatepostService createpostService;
    @PostMapping("/user/post/add/")
    public Map<String, String> createPost(@RequestParam Map<String, String> map) {
        String content = map.get("content");
        return createpostService.createPost(content);
    }
}
