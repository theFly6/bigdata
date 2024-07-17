package com.example.demo.repository;

import com.example.demo.entity.Job_salary_table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface Job_salary_tableRepository extends JpaRepository<Job_salary_table,Integer> {
   @Query(value = "select * from job_salary_table where dt=%?1 order by salary desc limit 10",nativeQuery = true)
    ArrayList findTop10(String s);

    @Query(value = "select * from job_salary_table where dt=%?1 order by salary desc",nativeQuery = true)
    Page<Job_salary_table> listAll(String s, Pageable pageable);
}
