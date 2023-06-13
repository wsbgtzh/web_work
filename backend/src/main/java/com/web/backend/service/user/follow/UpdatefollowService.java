package com.web.backend.service.user.follow;

import java.util.Map;

public interface UpdatefollowService {
    Map<String, String> updatefollow(String followId, String followed);
}
