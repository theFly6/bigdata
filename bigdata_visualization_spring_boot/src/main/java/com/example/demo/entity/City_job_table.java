package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "city_job_table")
public class City_job_table {

    @Id
    @Column(name = "dt")
    private String dt;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "job_num")
    private Integer jobNum;




}

