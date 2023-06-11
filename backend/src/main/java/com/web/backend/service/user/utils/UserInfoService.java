package com.web.backend.service.user.utils;

import com.web.backend.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    Map<String, String> GetUserInfo(String userId);
}
