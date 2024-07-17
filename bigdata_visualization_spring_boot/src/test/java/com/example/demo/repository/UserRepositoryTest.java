package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsemameAndPassword() {
        System.out.println(userRepository.findByUsemameAndPassword("pqq","123"));
    }

    @Test
    void findByPhoneOrEmail() {
    }

    @Test
    void existsByPhone() {
        System.out.println(userRepository.existsByPhone("18996438344"));
    }

    @Test
    void existsByEmail() {
    }
}