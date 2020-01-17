package com.tscloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserMapper mapper;

    public User checkUser(String username, String password) {
        return mapper.findUserByName(username);
    }

    public void regist(User user) {
        User temp = mapper.findUserByName(user.getUsername());
        if (temp != null){
            throw new RuntimeException("用户已存在");
        }
        mapper.addUser(user);
    }

    public void deleteUser(Integer id) {
        mapper.deleteUserByID(id);
    }

    public void updateUser(User user) {
        mapper.updateUser(user);
    }
}
