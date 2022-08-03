package com.example.demo.api;


import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AppUserService userService;


    @PostMapping("/login")

    public  String userLogin(){
        return "login";
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        ResponseEntity<List<Role>> response =ResponseEntity.ok().body(userService.getRoles());
        return  response;
    }


    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        ResponseEntity<List<AppUser>> response =  ResponseEntity.ok().body(userService.getUsers());
        return  response;
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(AppUser user){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(Role role){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("user/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/addtouser").toUriString());
        userService.AddRoleToUser(form.getUsername(),form.getRole());
        return ResponseEntity.created(uri).build();
    }


}
@Data
class RoleToUserForm{
    private String username;
    private String role;
}
