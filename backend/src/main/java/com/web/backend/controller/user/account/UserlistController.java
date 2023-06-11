package com.web.backend.controller.user.account;

import com.web.backend.pojo.User;
import com.web.backend.service.user.account.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserlistController {
    @Autowired
    UserlistService userlistService;
    @GetMapping("/user/userlist/")
    public List<User> getUserlist() {
        return userlistService.getUserlist();
    }
}
