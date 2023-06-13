package com.web.backend.controller.user.follow;

import com.web.backend.service.user.follow.FollowinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FollowinfoController {
    @Autowired
    private FollowinfoService followinfoService;
    @GetMapping("/user/followinfo/")
    public Map<String, String> addfollow(@RequestParam Map<String, String> map) {
        String userId = map.get("user_id");
        String targetId = map.get("target_id");
        return followinfoService.followinfo(Integer.parseInt(userId), Integer.parseInt(targetId));
    }
}
