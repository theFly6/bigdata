package com.example.demo.repository;


import com.example.demo.entity.City_job_table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface City_job_tableRepository extends JpaRepository<City_job_table,String> {
    @Query(value = "select * from city_job_table  where dt = %?1 order by job_num desc limit 10",nativeQuery = true)
    ArrayList findTop10(String s);
    @Query(value = "select * from city_job_table  where dt = %?1 order by job_num desc",nativeQuery = true)
    Page<City_job_table> listAll(String s, Pageable pageable);
}
