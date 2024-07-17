package com.example.demo.repository;

import com.example.demo.entity.Words_cloud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface Words_cloudRepository extends JpaRepository<Words_cloud,String> {
    @Query(value = "select * from words_cloud where dt=%?1",nativeQuery = true)
    ArrayList findAllByTime(String s);

    @Query(value = "select * from words_cloud where dt=%?1",nativeQuery = true)
    Page<Words_cloud> listAll(String s, Pageable pageable);
}
