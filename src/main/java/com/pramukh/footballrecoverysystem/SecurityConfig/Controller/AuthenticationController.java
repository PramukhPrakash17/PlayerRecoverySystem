package com.pramukh.footballrecoverysystem.SecurityConfig.Controller;

import com.pramukh.footballrecoverysystem.SecurityConfig.DTO.LoginDto;
import com.pramukh.footballrecoverysystem.SecurityConfig.DTO.RegisterDto;
import com.pramukh.footballrecoverysystem.SecurityConfig.Model.Roles;
import com.pramukh.footballrecoverysystem.SecurityConfig.Model.UserEntity;
import com.pramukh.footballrecoverysystem.SecurityConfig.Repo.RoleRepo;
import com.pramukh.footballrecoverysystem.SecurityConfig.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if(userRepo.existsByUsername(registerDto.getUsername()))
        {
            return ResponseEntity.badRequest().body("User already Exists!!");
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role role = roleRepo.findByName("USER").get();
        user.setRoles((List<Roles>) role);
        userRepo.save(user);
        return ResponseEntity.accepted().body("User Register Success");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
       Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("Login Success!!");
    }
}
