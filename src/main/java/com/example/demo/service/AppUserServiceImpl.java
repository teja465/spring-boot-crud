package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor //
@Transactional //
@Slf4j
public class AppUserServiceImpl implements AppUserService , UserDetailsService {

    @Autowired
    private AppUserRepository userRepo;
    @Autowired
    private RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public AppUser saveUser(AppUser user) {
        if ( userRepo.findByUsername(user.getUsername()) != null){
            log.info("user already present with gievn username {}",user.getUsername());
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving  new user {} to database",user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        if (roleRepo.findRoleByName(role.getName()) != null ){
            log.debug("Given  is already present {} ",role.getName());
            return null;
        }
        log.info("Saving  new role {} to database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String role) {
        log.info("Saving  new role tol user Role : {}  User : {} to database",role,username);
        AppUser user = userRepo.findByUsername(username);
        Role newrole = roleRepo.findRoleByName(role);
        user.getRoles().add(newrole);

    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching  user   User  {} ",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all Users ");
        return userRepo.findAll();
    }
    @Override
    public List<Role> getRoles(){
        log.info("Fetching all users");
        return roleRepo.findAll();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username);
        if (user == null){
            log.error("User not found in database for username {}",username);
            throw new UsernameNotFoundException("Username not found "+username);
        }
        log.error("Found user in database for username {} ,password {}",user.getUsername(),user.getPassword());

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        } );
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
