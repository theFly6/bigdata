package com.example.demo.repository;

import com.example.demo.entity.Company_scale_table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface Company_scale_tableRepository extends JpaRepository<Company_scale_table,Integer> {
    @Query(value = "select * from company_scale_table where dt= ?1 order by num desc",nativeQuery = true)
    ArrayList findAllByTime(String s);

    @Query(value = "select * from company_scale_table where dt like %:s% order by num desc",nativeQuery = true)
    Page<Company_scale_table> getBydt(String s, Pageable pageable);
}
