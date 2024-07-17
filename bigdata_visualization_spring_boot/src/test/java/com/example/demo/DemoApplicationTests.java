package com.example.demo;

import com.example.demo.repository.JoinerRepository;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired

	private UserRepository userRepository;

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	JoinerRepository joinerRepository;
	@Test
	void contextLoads() {
		System.out.println(joinerRepository.findByActivity_id(1));
		//System.out.println(joinerRepository.findByUser_id(1));
	}

}
