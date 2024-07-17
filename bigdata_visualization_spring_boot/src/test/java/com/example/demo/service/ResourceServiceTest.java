package com.example.demo.service;

import com.example.demo.entity.Resource_apply;
import com.example.demo.vo.Resource_applyVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceServiceTest {

    @Autowired
    ResourceService resourceService;
    @Test
    void all_resource_type() {
    }

    @Test
    void add_resource_type() {
    }

    @Test
    void add_resource() {
    }

    @Test
    void apply_resource() {
        LocalDateTime localDateTime  = LocalDateTime.of(2024, 6, 9, 20, 30, 45);
        LocalDateTime localDateTime2  = LocalDateTime.of(2024, 6, 10, 20, 30, 45);
        Resource_applyVo resourceapply = new Resource_applyVo();
        resourceapply.setActivity_id(1);
        resourceapply.setResource_id(1);
        resourceapply.setApplyer_id(1);
        resourceapply.setNum(2);
        resourceapply.setState(0);
        resourceapply.setStart_time(localDateTime);
        resourceapply.setEnd_time(localDateTime2);
        System.out.println(resourceService.apply_resource(resourceapply));
    }

    @Test
    void detect_resource() {
    }
}