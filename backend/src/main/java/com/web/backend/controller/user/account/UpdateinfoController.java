package com.web.backend.controller.user.account;

import com.web.backend.service.user.account.UpdateinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateinfoController {
    @Autowired
    private UpdateinfoService updateinfoService;
    @PostMapping("/user/account/updateinfo")
    public Map<String, String> updateinfo(@RequestParam Map<String, String> map) {
        String userId = map.get("user_id");
        String followCount = map.get("follow_count");
        return updateinfoService.updateinfo(userId, followCount);
    }
}
