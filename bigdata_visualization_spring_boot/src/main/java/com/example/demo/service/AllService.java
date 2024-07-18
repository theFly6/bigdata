package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.utils.Result;
import com.example.demo.vo.InterfaceVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AllService {
    Result<ArrayList> show_job_salary(String s);

    Result<ArrayList> show_city_job(String s);

    Result<ArrayList> show_company_property(String s);

    Result<ArrayList> show_company_scale(String s);

    Result<ArrayList> show_job_post(String s);

    Result<ArrayList> show_word_cloud(String s);

    Result<Page<City_job_table>> show_city_job_table(InterfaceVo interfaceVo);

    Result<Page<Company_property_table>> show_company_property_table(InterfaceVo interfaceVo);

    Result<Page<Company_scale_table>> show_company_scale_table(InterfaceVo interfaceVo);

    Result<Page<Job_post_table>> show_job_post_table(InterfaceVo interfaceVo);

    Result<Page<Job_salary_table>> show_job_salary_table(InterfaceVo interfaceVo);

    Result<Page<Words_cloud>> show_word_cloud_table(InterfaceVo interfaceVo);

    Result<Page<Origindata>> show_origin_table(InterfaceVo interfaceVo);


}
