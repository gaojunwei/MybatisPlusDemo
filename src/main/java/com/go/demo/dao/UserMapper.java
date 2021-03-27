package com.go.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.go.demo.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据名字查询数据
     */
    List<User> listByName(@Param("name") String name);
}
