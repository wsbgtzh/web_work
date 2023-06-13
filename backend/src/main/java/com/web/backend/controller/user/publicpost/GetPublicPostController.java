package com.web.backend.controller.user.publicpost;

import com.web.backend.pojo.Publicpost;
import com.web.backend.service.user.publicpost.GetPublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPublicPostController {
    @Autowired
    private GetPublicPostService getPublicPostService;
    @GetMapping("/user/getpublicpost/")
    public List<Publicpost> getpublicpost() {
        return getPublicPostService.getpublicpost();
    }
}
