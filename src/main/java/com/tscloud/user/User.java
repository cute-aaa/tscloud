package com.tscloud.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String usertype;
    private List<Integer> containerList;

    public static String COMMON_USER = "common";
    public static String ADMIN_USER = "admin";

    public User(String username, String password) {
        this(username, password, COMMON_USER);
    }

    public User(String username, String password, String usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        containerList = new ArrayList<>();
    }

    public User(Integer id, String username, String password, String usertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", containerList=" + containerList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public List<Integer> getContainerList() {
        return containerList;
    }

    public void addContainer(Integer containerID){
        containerList.add(containerID);
    }
}
