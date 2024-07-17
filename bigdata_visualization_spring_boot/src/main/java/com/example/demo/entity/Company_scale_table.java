package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "company_scale_table")

public class Company_scale_table {
        @Id
        @Column(name = "dt")
        private String dt;

        @Column(name = "company_size")
        private String company_size;

        @Column(name = "num")
        private Integer num;





}
