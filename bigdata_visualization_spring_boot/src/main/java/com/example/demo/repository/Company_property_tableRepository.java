package com.example.demo.repository;

import com.example.demo.entity.Company_property_table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface Company_property_tableRepository extends JpaRepository<Company_property_table,String> {
    @Query(value = "select * from company_property_table where time=%?1",nativeQuery = true)
    ArrayList findAllByTime(String s);
    @Query(value = "select * from company_property_table where time=%?1",nativeQuery = true)
    Page<Company_property_table> listAll(String s, Pageable pageable);
}
