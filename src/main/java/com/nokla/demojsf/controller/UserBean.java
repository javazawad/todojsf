package com.nokla.demojsf.controller;

import com.nokla.demojsf.entity.user.User;
import com.nokla.demojsf.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Named
@RequestScoped
@Getter @Setter
public class UserBean {
    @Inject
    UserService userService;

    private List<User> users;
    private final User user = new User();

    @PostConstruct
    public void init(){
        users = userService.getAllUsers();
    }

    public void saveUser(){
        userService.createUser(user);
        users = userService.getAllUsers();
    }





}
