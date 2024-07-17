package com.example.demo.service.serviceImpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.AllService;
import com.example.demo.utils.Result;
import com.example.demo.vo.InterfaceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AllServiceImpl implements AllService {

    @Autowired
    City_job_tableRepository cityJobTableRepository;
    @Autowired
    Company_property_tableRepository companyPropertyTableRepository;
    @Autowired
    Company_scale_tableRepository company_scale_tableRepository;
    @Autowired
    Job_post_tableRepository jobPostTableRepository;
    @Autowired
    Job_salary_tableRepository jobSalaryTableRepository;
    @Autowired
    Words_cloudRepository wordsCloudRepository;
    @Autowired
    OrigindataRepository origindataRepository;
    @Override
    public Result<ArrayList> show_job_salary(String s) {
        return Result.success(jobSalaryTableRepository.findTop10(s));
    }

    @Override
    public Result<ArrayList> show_city_job(String s) {
        return Result.success(cityJobTableRepository.findTop10(s));
    }

    @Override
    public Result<ArrayList> show_company_property(String s) {
        return Result.success(companyPropertyTableRepository.findAllByTime(s));
    }

    @Override
    public Result<ArrayList> show_company_scale(String s) {
        return Result.success(company_scale_tableRepository.findAllByTime(s));
    }

    @Override
    public Result<ArrayList> show_job_post(String s) {

        return Result.success(jobPostTableRepository.findAllByTime(s));
    }

    @Override
    public Result<ArrayList> show_word_cloud(String s) {

        return Result.success(wordsCloudRepository.findAllByTime(s));
    }

    @Override
    public Result<Page<City_job_table>> show_city_job_table(InterfaceVo interfaceVo) {
        return Result.success(cityJobTableRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Company_property_table>> show_company_property_table(InterfaceVo interfaceVo) {
        return Result.success(companyPropertyTableRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Company_scale_table>> show_company_scale_table(InterfaceVo interfaceVo) {

        return Result.success(company_scale_tableRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Job_post_table>> show_job_post_table(InterfaceVo interfaceVo) {
        return Result.success(jobPostTableRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Job_salary_table>> show_job_salary_table(InterfaceVo interfaceVo) {
        return Result.success(jobSalaryTableRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Words_cloud>> show_word_cloud_table(InterfaceVo interfaceVo) {
        return Result.success(wordsCloudRepository.listAll(interfaceVo.s,interfaceVo.pageable));
    }

    @Override
    public Result<Page<Origindata>> show_origin_table(InterfaceVo interfaceVo) {
        return origindataRepository.findAllByPage(interfaceVo.s,interfaceVo.pageable);
    }
}
