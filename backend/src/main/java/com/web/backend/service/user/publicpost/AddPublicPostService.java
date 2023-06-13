package com.web.backend.service.user.publicpost;

import java.util.Map;

public interface AddPublicPostService {
    Map<String, String> addpublicpost(Integer user_id, String content, String username, String photo);
}
