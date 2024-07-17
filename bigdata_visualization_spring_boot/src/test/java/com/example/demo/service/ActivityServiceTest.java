package com.example.demo.service;

import com.example.demo.entity.Schedule;
import com.example.demo.repository.Act_templateRepository;
import com.example.demo.vo.Activityvo;
import com.example.demo.vo.ScheduleVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ActivityServiceTest {


    @Autowired

    private    ActivityService activityService;

    Act_templateRepository act_templateRepository;

    @Test
    void allact_template() {
        System.out.println(activityService.allact_template());
    }

    @Test
    void create() {
        LocalDateTime localDateTime  = LocalDateTime.of(2024, 6, 10, 20, 30, 45);
        LocalDateTime localDateTime2  = LocalDateTime.of(2024, 6, 11, 20, 30, 45);
        Activityvo activityvo = new Activityvo();
        activityvo.setName("睡觉");
        activityvo.setCreator_id(3);
        activityvo.setLocation("宿舍");
        activityvo.setJoiner_number(10);
        activityvo.setStart_time(localDateTime);
        activityvo.setEnd_time(localDateTime2);
        activityvo.setState("报名中");
        activityvo.setMax_num(20);
        System.out.println(activityService.create(activityvo));
    }

    @Test
    void schCreate() {
        LocalDateTime localDateTime  = LocalDateTime.of(2024, 6, 1, 20, 30, 45);
        LocalDateTime localDateTime2  = LocalDateTime.of(2024, 6, 9, 20, 30, 45);;
        ScheduleVo schedule=new ScheduleVo();
        schedule.setActivity_id(1);
        schedule.setName("睡觉");
        schedule.setContext("睡觉");
        schedule.setStart_time(localDateTime);
        schedule.setEnd_time(localDateTime2);
        System.out.println(activityService.schCreate(schedule));
    }

    @Test
    void setState() {
        System.out.println(activityService.setState(1,"已结束"));
    }

    @Test
    void update() {
    }

    @Test
    void findByKey() {
        System.out.println(activityService.findByKey("会议"));
    }
}