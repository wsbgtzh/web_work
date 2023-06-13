package com.web.backend.service.user.follow;

import java.util.Map;

public interface FollowinfoService {
    Map<String, String> followinfo(Integer userId, Integer targetId);
}
