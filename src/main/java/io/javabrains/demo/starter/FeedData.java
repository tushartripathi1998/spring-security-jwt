package io.javabrains.demo.starter;

import io.javabrains.demo.model.User;
import io.javabrains.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FeedData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setRoles("ROLE_USER");
        user.setActive(true);
        user.setPassword("boot");
        user.setUserName("spring");
        userRepository.save(user);
    }
}
