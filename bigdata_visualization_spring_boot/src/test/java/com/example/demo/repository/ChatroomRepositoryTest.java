package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class ChatroomRepositoryTest {
    @Autowired
    ChatroomRepository chatroomRepository;

    @Test
    void findAllByActivityId() {
        System.out.println(chatroomRepository.findAllByActivityId(1));
    }
}