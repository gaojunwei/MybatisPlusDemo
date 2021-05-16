package com.go;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.go.demo.ApplicationDemo;
import com.go.demo.common.utils.DateFormatUtils;
import com.go.demo.common.utils.MDCUtils;
import com.go.demo.dao.UserMapper;
import com.go.demo.dao.domain.User;
import com.go.demo.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationDemo.class)
@Slf4j
public class SpringTest {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private Gson gson;

    @Before
    public void init(){
        log.info("设置前");
        MDCUtils.initReqId();
        log.info("设置后");
    }

    @After
    public void end(){
        log.info("结束A");
        MDCUtils.removeReqId();
        log.info("结束B");
    }


    @Test
    public void testSelect() throws ParseException {
        /*******************/
        User user = userMapper.selectById("1");
        log.info("根据ID查询:"+gson.toJson(user));

        /*******************/
        List<User> userList = userMapper.selectList(null);
        log.info("查询所有："+gson.toJson(userList));

        /*******************/
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name").eq("name","Jone");
        User usr = userMapper.selectOne(query);
        log.info("查询指定条件的一条数据："+ gson.toJson(usr));

        /*******************/
        QueryWrapper<User> query2 = new QueryWrapper<>();
        query2.eq("name","Jone");
        query2.select("name","age");
        User usr2 = userMapper.selectOne(query2);
        log.info("查询指定字段："+ gson.toJson(usr2));

        /*******************/
        QueryWrapper<User> query3 = new QueryWrapper<>();
        query3.likeLeft("name","e");
        List<User> usrs1 = userMapper.selectList(query3);
        log.info("模糊查询："+ gson.toJson(usrs1));

        /*******************/
        QueryWrapper<User> query4 = new QueryWrapper<>();
        query4.ge("created_time", DateFormatUtils.parseDate("2020-01-02 12:00:00"));
        query4.ge("created_time", DateFormatUtils.parseDate("2020-01-02 12:00:00"));
        query4.orderByDesc("created_time");
        List<User> users2 = userMapper.selectList(query4);
        log.info("时间范围查询-并按事件倒序排："+ gson.toJson(users2));

        /*******************/
        QueryWrapper<User> query5 = new QueryWrapper<>();
        query5.in("age", Arrays.asList(20,21));
        List<User> users3 = userMapper.selectList(query5);
        log.info("in查询："+ gson.toJson(users3));

        /*******************/
        QueryWrapper<User> query6 = new QueryWrapper<>();
        query6.ge("age", 20);
        query6.select("distinct name");
        List<User> users4 = userMapper.selectList(query6);
        log.info("distinct查询："+ gson.toJson(users4));

        /*******************/
        QueryWrapper<User> query7 = new QueryWrapper<>();
        query7.eq("age", 18).or().eq("age",20);
        query7.orderByDesc("created_time");
        List<User> users5 = userMapper.selectList(query7);
        log.info("or关系查询："+ gson.toJson(users5));

        /*******************/
        QueryWrapper<User> query8 = new QueryWrapper<>();
        query8.ge("age", 18);
        query8.orderByDesc("created_time");
        //组织分页参数
        Page<User> page = new Page<>(0, 2);
        Page<User> users6 = userMapper.selectPage(page,query8);
        log.info("是否有下一页："+users6.hasNext());
        log.info("是否有上一页："+users6.hasPrevious());
        log.info("总条数："+users6.getTotal());
        log.info("本页数据数："+users6.getRecords().size());
        log.info("分页查询："+ gson.toJson(users6));

        /*******************/
        String name = "Jack";
        List<User> users7 = userMapper.listByName(name);
        log.info("自定义mapper查询："+ gson.toJson(users7));

        /*******************/
        List<User> users8 = userService.listByName(name);
        log.info("生成Service使用："+ gson.toJson(users8));

    }
}
