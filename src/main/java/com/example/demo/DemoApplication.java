package com.example.demo;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo.entity"})
@Service
public class DemoApplication  implements CommandLineRunner {

	@Autowired
	private AppUserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


		System.out.println("Executing commands to fill up db ");
		userService.saveRole( new Role(null,"ROLE_USER"));
		userService.saveRole( new Role(null,"ROLE_ADMIN"));
		userService.saveRole( new Role(null,"ROLE_MANAGER"));
		userService.saveRole( new Role(null,"ROLE_SUPER_USER_ADMIN"));

		userService.saveUser(new AppUser(null,"tejaaa","tejaaa@gmail.com","tejaaa",new ArrayList<>()));
		userService.saveUser(new AppUser(null,"Teja","teja@gmail.com","1234",new ArrayList<>()));
		userService.saveUser(new AppUser(null,"sai","sai@gmail.com","1234",new ArrayList<>()));
		userService.saveUser(new AppUser(null,"yeshwanth","yeshwanth@gmail.com","1234",new ArrayList<>()));


	}
}
