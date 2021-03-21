package com.go;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.go.demo.ApplicationDemo;
import com.go.demo.common.utils.DateFormatUtils;
import com.go.demo.dao.UserMapper;
import com.go.demo.dao.domain.User;
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
public class SpringTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() throws ParseException {
        /*******************/
        User user = userMapper.selectById("1");
        System.out.println("根据ID查询:"+JSON.toJSONString(user));

        /*******************/
        List<User> userList = userMapper.selectList(null);
        System.out.println("查询所有："+JSON.toJSONString(userList));

        /*******************/
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name").eq("name","Jone");
        User usr = userMapper.selectOne(query);
        System.out.println("查询指定条件的一条数据："+ JSON.toJSONString(usr));

        /*******************/
        QueryWrapper<User> query2 = new QueryWrapper<>();
        query2.eq("name","Jone");
        query2.select("name","age");
        User usr2 = userMapper.selectOne(query2);
        System.out.println("查询指定字段："+ JSON.toJSONString(usr2));

        /*******************/
        QueryWrapper<User> query3 = new QueryWrapper<>();
        query3.likeLeft("name","e");
        List<User> usrs1 = userMapper.selectList(query3);
        System.out.println("模糊查询："+ JSON.toJSONString(usrs1));

        /*******************/
        QueryWrapper<User> query4 = new QueryWrapper<>();
        query4.ge("created_time", DateFormatUtils.parseDate("2020-01-02 12:00:00"));
        query4.ge("created_time", DateFormatUtils.parseDate("2020-01-02 12:00:00"));
        query4.orderByDesc("created_time");
        List<User> users2 = userMapper.selectList(query4);
        System.out.println("时间范围查询-并按事件倒序排："+ JSON.toJSONString(users2));

        /*******************/
        QueryWrapper<User> query5 = new QueryWrapper<>();
        query5.in("age", Arrays.asList(20,21));
        List<User> users3 = userMapper.selectList(query5);
        System.out.println("in查询："+ JSON.toJSONString(users3));

        /*******************/
        QueryWrapper<User> query6 = new QueryWrapper<>();
        query6.ge("age", 20);
        query6.select("distinct name");
        List<User> users4 = userMapper.selectList(query6);
        System.out.println("distinct查询："+ JSON.toJSONString(users4));

        /*******************/
        QueryWrapper<User> query7 = new QueryWrapper<>();
        query7.eq("age", 18).or().eq("age",20);
        query7.orderByDesc("created_time");
        List<User> users5 = userMapper.selectList(query7);
        System.out.println("or关系查询："+ JSON.toJSONString(users5));

        /*******************/
        QueryWrapper<User> query8 = new QueryWrapper<>();
        query8.ge("age", 18);
        query8.orderByDesc("created_time");
        //组织分页参数
        Page<User> page = new Page<>(0, 2);
        Page<User> users6 = userMapper.selectPage(page,query8);
        System.out.println("是否有下一页："+users6.hasNext());
        System.out.println("是否有上一页："+users6.hasPrevious());
        System.out.println("总条数："+users6.getTotal());
        System.out.println("本页数据数："+users6.getRecords().size());
        System.out.println("分页查询："+ JSON.toJSONString(users6));

        /*******************/
        String name = "Jack";
        List<User> users7 = userMapper.getNeme(name);
        System.out.println("自定义mapper查询："+ JSON.toJSONString(users7));

    }
}
