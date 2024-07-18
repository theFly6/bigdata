package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "company_scale_table")

public class Company_scale_table {


        @Column(name = "dt")
        private String dt;


        @Column(name = "company_size")
        private String company_size;

        @Column(name = "num")
        private Integer num;

        @Id
        @Column(name="id")
        private Integer id;



}
