package com.example.porjet_security.usersData;

import com.example.porjet_security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserApp("user1", "password1"));
        userRepository.save(new UserApp("admin", "adminpass"));

        System.out.println("Données initiales insérées dans user_app");
    }
}
