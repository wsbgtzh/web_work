package com.web.backend.controller.user.utils;

import com.web.backend.pojo.User;
import com.web.backend.service.user.utils.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/user/getinfo/")
    public Map<String, String> GetUserInfo(@RequestParam Map<String, String> map) {
        String userId = map.get("userId");
        return userInfoService.GetUserInfo(userId);
    }
}
