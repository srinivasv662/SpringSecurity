package com.example.SecurityPrac.SecurityAppli.config;

import com.example.SecurityPrac.SecurityAppli.entities.User;
import com.example.SecurityPrac.SecurityAppli.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeUsers(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByEmail("sri@gmail.com").isEmpty()) {
                User user = new User();

                user.setEmail("sri@gmail.com");
                user.setPassword(passwordEncoder.encode("pass"));
                user.setRole("ROLE_USER");

                userRepository.save(user);
            }

            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                User admin = new User();

                admin.setEmail("admin@gmail.com");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
            }
        };
    }

}
