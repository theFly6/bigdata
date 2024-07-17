package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "origin_data")
public class Origindata {
    @Id
    private String dt;
    private String company_name;
    private String company_size;
    private String company_type;
    private String job_type;
    private String job_name;
    private String edu;
    private String salary;
    private Integer people_need;
    private String city;
    private String require_content;
}

