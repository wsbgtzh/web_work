package com.web.backend.controller.user.publicpost;

import com.web.backend.service.user.publicpost.AddPublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddPublicPostController {
    @Autowired
    AddPublicPostService addPublicPostService;
    @PostMapping("/user/publicpost/")
    public Map<String, String> addpublicpost(@RequestParam Map<String, String> map) {
        Integer user_id = Integer.parseInt(map.get("user_id"));
        String content = map.get("content");
        String username = map.get("username");
        String photo = map.get("photo");
        return addPublicPostService.addpublicpost(user_id, content, username, photo);
    }
}
