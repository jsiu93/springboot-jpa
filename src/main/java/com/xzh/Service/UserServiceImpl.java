package com.xzh.Service;

import com.xzh.common.WebPageRequest;
import com.xzh.pojo.User;
import com.xzh.repository.UserRepository;
import com.xzh.utils.FastJsonConvertUtil;
import com.xzh.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(WebPageRequest request) {

        PageRequest pageReq = PageUtil.getPageRequest(request.getPage(), request.getSize());
        Page<User> paged = userRepository.findAll(pageReq);
        List<User> content = paged.getContent();

        log.debug("pageResult={}" , FastJsonConvertUtil.convertObjectToJSON(paged));

        return paged;
    }

}
