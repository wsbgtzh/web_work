package com.web.backend.service.user.follow;

import com.web.backend.pojo.Follow;

import java.util.List;
import java.util.Map;

public interface GetfollowService {
    List<Follow> getfollow(String userId);
}
