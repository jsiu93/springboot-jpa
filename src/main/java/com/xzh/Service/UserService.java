package com.xzh.Service;

import com.xzh.common.WebPageRequest;
import com.xzh.pojo.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User saveUser(User user);

    Page<User> findAll(WebPageRequest request);
}
