package com.web.backend.controller.user.account;

import com.web.backend.pojo.User;
import com.web.backend.service.user.account.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserlistController {
    @Autowired
    UserlistService userlistService;
    @GetMapping("/user/userlist/")
    public List<User> getUserlist(@RequestParam Map<String, String> map) {
        String user_id = map.get("user_id");
        return userlistService.getUserlist(user_id);
    }
}
