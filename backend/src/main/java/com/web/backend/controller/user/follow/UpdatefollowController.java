package com.web.backend.controller.user.follow;
import com.web.backend.service.user.follow.UpdatefollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UpdatefollowController {
    @Autowired
    private UpdatefollowService updatefollowService;
    @PostMapping("/user/updatefollow")
    public Map<String, String> updatefollow(@RequestParam Map<String, String> map) {
        String followId = map.get("follow_id");
        String followed = map.get("followed");
        return updatefollowService.updatefollow(followId, followed);
    }
}
