package com.ashu.demo.security;

import com.ashu.demo.model.AppRole;
import com.ashu.demo.model.AppUser;
import com.ashu.demo.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class SSUDS implements UserDetailsService {


    private AppUserRepository userRepo;

    public SSUDS(AppUserRepository userRepository) {
        this.userRepo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        AppUser thisUser = userRepo.findAppUserByUsername(username);
        return new User(thisUser.getUsername(), thisUser.getPassword(), grantedAuthorities(thisUser));
    }

    public Set<GrantedAuthority> grantedAuthorities(AppUser user) {
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        for (AppRole eachRole : user.getRoles()) {
            userAuthorities.add(new SimpleGrantedAuthority(eachRole.getRoleName()));
        }
        return userAuthorities;
    }
}

