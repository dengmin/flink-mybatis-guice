package com.baieapp.service;

import com.baieapp.mapper.UserMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @Author dengmin
 * @Created 2020/3/22 09:23
 */
@Singleton
public class HelloServiceImpl implements HelloService {

    @Inject
    private UserMapper userMapper;

    @Override
    public String say(String name) {
        System.out.println(userMapper.getUser(1L));
        return "hello: ".concat(name);
    }
}
