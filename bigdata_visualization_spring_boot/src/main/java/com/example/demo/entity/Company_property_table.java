package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company_property_table")
public class Company_property_table {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "time")
    private String time;

    @Column(name = "guoqi")
    private Integer guoqi;

    @Column(name = "minying")
    private Integer minying;

    @Column(name = "waizi")
    private Integer waizi;

    @Column(name = "hezi")
    private Integer hezi;

    @Column(name = "shangshi")
    private Integer shangshi;

    @Column(name = "chuangye")
    private Integer chuangye;

    @Column(name = "shiyedanwei")
    private Integer shiyedanwei;


}

