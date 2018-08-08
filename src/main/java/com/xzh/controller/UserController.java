package com.xzh.controller;

import com.xzh.Service.UserService;
import com.xzh.common.WebPageRequest;
import com.xzh.common.ServerResponse;
import com.xzh.model.UserRequest;
import com.xzh.pojo.User;
import com.xzh.utils.BeanCopyUtil;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("save")
    public ServerResponse save(@RequestBody  UserRequest request) {
        User user = BeanCopyUtil.copyTo(request, new User());
        user.setId(Sid.next());
        user.setCtime(new Date());
        userService.saveUser(user);

        return ServerResponse.createBySuccess();

    }

    @PostMapping("list")
    public ServerResponse list(@RequestBody WebPageRequest request) {
        Page<User> all = userService.findAll(request);
        return ServerResponse.createBySuccess(all);
    }
}
