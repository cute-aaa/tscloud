package com.tscloud;

import com.tscloud.container.Container;
import com.tscloud.container.ContainerMapper;
import com.tscloud.user.User;
import com.tscloud.user.UserMapper;
import com.tscloud.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class jdbcTest {

    @Autowired
    UserMapper mapper;

    @Autowired
    ContainerMapper containerMapper;

    @Autowired
    UserService service;

    @Test
    void mapperTest(){
        User user = mapper.findUserByName("1");
//        short result = service.checkUser("1", "1");
        System.out.println(user);
    }

    @Test
    void serviceTest(){
        User user = service.checkUser("1", "1");
        System.out.println(user);
    }

    @Test
    void addContainer(){
        Container container = new Container(1, "test2", new Date(), new Date());
        containerMapper.createContainer(container);
        System.out.println(containerMapper.getContainersByUserID(1));
    }
}
