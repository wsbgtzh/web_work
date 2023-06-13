package com.web.backend.service.user.account;

import java.util.Map;

public interface UpdateinfoService {
    Map<String, String> updateinfo(String user_id, String followerCount);
}
