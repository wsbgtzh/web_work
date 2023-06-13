package com.web.backend.controller.user.follow;

import com.web.backend.pojo.Follow;
import com.web.backend.service.user.follow.GetfollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetfollowController {
    @Autowired
    private GetfollowService getfollowService;
    @GetMapping("/user/follow")
    public List<Follow> getfollow(@RequestParam Map<String, String> map) {
        String userId = map.get("user_id");
        return getfollowService.getfollow(userId);
    }

}
