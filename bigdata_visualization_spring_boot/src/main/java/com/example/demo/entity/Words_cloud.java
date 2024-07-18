package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "words_cloud")
public class Words_cloud {


    @Column(name = "junior_college")
    private Integer juniorCollege;

    @Column(name = "bachelor")
    private Integer bachelor;

    @Column(name = "master")
    private Integer master;

    @Column(name = "doctor")
    private Integer doctor;

    @Column(name = "buxian")
    private Integer buxian;

    @Column(name = "no_require")
    private Integer noRequire;

    @Column(name = "below_junior_high_school")
    private Integer belowJuniorHighSchool;

    @Column(name = "technical_secondary_school")
    private Integer technicalSecondarySchool;

    @Column(name = "zhongzhuan", nullable = false)
    private Integer zhongzhuan;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "dt", length = 255)
    private String time;

    // Constructors are automatically generated by @Data
    // No need to explicitly define getters and setters

    // You can optionally add other constructors if needed

}

