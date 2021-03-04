package io.javabrains.demo.service;

import io.javabrains.demo.model.CustomUserDetail;
import io.javabrains.demo.model.User;
import io.javabrains.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userData = userRepository.findByUserName(username);
        userData.orElseThrow(()->new UsernameNotFoundException("not found username : "+username));
        return userData.map(CustomUserDetail::new).get();
    }
}
