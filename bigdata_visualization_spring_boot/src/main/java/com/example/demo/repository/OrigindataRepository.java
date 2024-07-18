package com.example.demo.repository;

import com.example.demo.entity.Origindata;
import com.example.demo.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrigindataRepository extends JpaRepository<Origindata,String> {
    @Query(value = "select * from origin_data where dt=%?1",nativeQuery = true)
    Page<Origindata> findAllByPage(String s, Pageable pageable);


}
