package com.go.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.demo.dao.domain.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User>  listByName(String name);
}
