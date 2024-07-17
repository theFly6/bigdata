package com.example.demo.service;

import com.example.demo.entity.Notice;
import com.example.demo.vo.NoticeVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;
    @Test
    void create_notice_template() {
    }

    @Test
    void update_notice_template() {
    }

    @Test
    void delete_notice_template() {
    }

    @Test
    void create_notice() {
        LocalDateTime localDateTime  = LocalDateTime.of(2024, 6, 20, 23, 20, 45);
        NoticeVo notice = new NoticeVo();
        notice.setNotice_type_id(6);
        notice.setContext("睡觉");
        notice.setActivity_id(2);
        notice.setSend_time(localDateTime);
        System.out.println(noticeService.create_notice(notice));
    }

    @Test
    void count_notice() {
        System.out.println(noticeService.count_notice(2));
    }
}