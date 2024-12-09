package com.pramukh.footballrecoverysystem.SecurityConfig;

import com.pramukh.footballrecoverysystem.SecurityConfig.Model.Roles;
import com.pramukh.footballrecoverysystem.SecurityConfig.Model.UserEntity;
import com.pramukh.footballrecoverysystem.SecurityConfig.Repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
        Collection<GrantedAuthority> roles_list = new ArrayList<>();
        for(Roles role : user.getRoles())
        {
            roles_list.add(new SimpleGrantedAuthority("ROLE_" +role.getName()));
        }
        return new User(user.getUsername(),user.getPassword(),roles_list);
    }
}
