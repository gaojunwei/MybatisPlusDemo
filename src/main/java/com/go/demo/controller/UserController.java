package com.go.demo.controller;

import com.go.demo.common.enums.SystemCodeEnums;
import com.go.demo.dao.domain.User;
import com.go.demo.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.go.demo.common.response.SingleResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private Gson gson;

    @GetMapping("id")
    public SingleResult<User> getById(@RequestParam Long id){
        logger.info("根据ID获取用户信息 start id:{}",id);
        SingleResult<User> result = new SingleResult<>();
        SystemCodeEnums.success.applyVal(result);
        result.setData(userService.getById(id));
        logger.info("根据ID获取用户信息 end result:{}",gson.toJson(result));
        return result;
    }
}
