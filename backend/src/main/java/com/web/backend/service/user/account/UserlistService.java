package com.web.backend.service.user.account;

import com.web.backend.pojo.User;

import java.util.List;

public interface UserlistService {
    List<User> getUserlist(String user_id);
}
