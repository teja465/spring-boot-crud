package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import org.apache.catalina.User;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void AddRoleToUser(String username, String Role);
    AppUser getUser(String  username);
    List<AppUser> getUsers();

    List<Role> getRoles();

}
