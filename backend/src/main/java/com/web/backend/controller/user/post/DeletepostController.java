package com.web.backend.controller.user.post;

import com.web.backend.service.user.post.DeletepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeletepostController {
    @Autowired
    private DeletepostService deletepostService;
    @DeleteMapping("/user/post/delete/")
    public Map<String, String> deletepost(@RequestParam Map<String, String> map) {
        String id = map.get("id");
        return deletepostService.deletepost(Integer.parseInt(id));
    }
}
