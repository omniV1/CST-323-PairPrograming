package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.models.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersDetailsService implements UserDetailsService {
    
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user by username in the database
        UserEntity userEntity = usersRepository.findByUsername(username);
        
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        
        // Map role to GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
        
        // Map enabled to account enabled flag
        // Return Spring Security UserDetails object
        return new User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            userEntity.isEnabled(),  // enabled flag
            true,  // accountNonExpired
            true,  // credentialsNonExpired
            true,  // accountNonLocked
            authorities  // authorities (roles)
        );
    }
}
