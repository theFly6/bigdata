package com.example.demo.repository;

import jakarta.annotation.Resource;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ScheduleRepositoryTest {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Resource
    JavaMailSender javaMailSender;
    @Test
    void findAllByActivity_id() {
        System.out.println(scheduleRepository.findAllByActivity_id(1));
    }

    @Test
    void sendMsg(){
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(new InternetAddress(MimeUtility.encodeText("活动管理系统官方: ")+"<1973834626@qq.com>").toString());
            message.setTo("2702749893@qq.com");
            message.setSubject("日程提醒");
            message.setText("您参与的活动开始了新日程");
            javaMailSender.send(message);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
    }
}