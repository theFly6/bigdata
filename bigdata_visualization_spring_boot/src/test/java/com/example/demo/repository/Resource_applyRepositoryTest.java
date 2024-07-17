package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class Resource_applyRepositoryTest {
    @Autowired
    Resource_applyRepository resourceApplyRepository;

    @Test
    void findAllByResourceIdandState() {
        System.out.println(resourceApplyRepository.findAllByResourceIdandState(1));
    }

    @Test
    void findAllByApplyerId() {
    }
}