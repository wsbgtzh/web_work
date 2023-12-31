package com.web.backend.service.Impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.backend.mapper.UserMapper;
import com.web.backend.pojo.User;
import com.web.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }
        if (password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();

        if (username.length() == 0) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if (username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码长度不能大于100");
            return map;
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }
        String encodedPassword = passwordEncoder.encode(password);
        List<String> list = new LinkedList<String>(){{
            add("https://s1.ax1x.com/2023/06/14/pCnylKH.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCny1rd.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCny3qA.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCnyGVI.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCnyYIP.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCnyUG8.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCnydxg.jpg");
            add("https://s1.ax1x.com/2023/06/14/pCnyDqs.jpg");
        }};
        Random r = new Random();
        String photo = list.get(r.nextInt(8));
        User user = new User(null, username, encodedPassword, photo, null);
        userMapper.insert(user);
        map.put("error_message", "success");
        return map;
    }
}
