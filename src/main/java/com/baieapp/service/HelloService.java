package com.baieapp.service;

import com.google.inject.ImplementedBy;

/**
 * @Author dengmin
 * @Created 2020/3/22 09:22
 */
@ImplementedBy(HelloServiceImpl.class)
public interface HelloService {
    String say(String name);
}
