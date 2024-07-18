package com.example.demo.repository;

import com.example.demo.entity.Job_post_table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface Job_post_tableRepository extends JpaRepository<Job_post_table,String> {
    @Query(value = "select * from job_post_table  order by post_time",nativeQuery = true)
    ArrayList findAllByTime(String s);

    @Query(value = "select * from job_post_table order by post_time",nativeQuery = true)
    Page<Job_post_table> listAll(String s, Pageable pageable);
}
