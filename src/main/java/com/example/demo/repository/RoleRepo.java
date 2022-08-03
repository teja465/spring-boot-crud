package com.example.demo.repository;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {


    Role findRoleByName(String name);

}
