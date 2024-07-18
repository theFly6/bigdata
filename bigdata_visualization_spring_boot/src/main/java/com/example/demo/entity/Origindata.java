package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "origin_data")
public class Origindata {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="dt")
    private String dt;
    @Column(name="company_name")
    private String company_name;
    @Column(name="company_size")
    private String company_size;
    @Column(name="company_type")
    private String company_type;
    @Column(name="job_type")
    private String job_type;
    @Column(name="job_name")
    private String job_name;
    @Column(name="edu")
    private String edu;
    @Column(name="salary")
    private String salary;
    @Column(name="people_need")
    private Integer people_need;
    @Column(name="city")
    private String city;
    @Column(name="require_content")
    private String require_content;
}

