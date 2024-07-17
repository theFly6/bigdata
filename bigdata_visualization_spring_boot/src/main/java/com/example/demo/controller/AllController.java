package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.AllService;
import com.example.demo.utils.Result;
import com.example.demo.vo.InterfaceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/show")
public class AllController {
    @Autowired
    AllService allService;



    @RequestMapping("/cityJob")
    public Result<ArrayList> show_city_job(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_city_job(target);

    }
    @RequestMapping("/companyProperty")
    public Result<ArrayList> show_company_property(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_company_property(target);

    }
    @RequestMapping("/companyScale")
    public Result<ArrayList> show_company_scale(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_company_scale(target);

    }
    @RequestMapping("/jobPost")
    public Result<ArrayList> show_job_post(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_job_post(target);

    }

    @RequestMapping("/jobSalary")
    public Result<ArrayList> show_job_salary(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_job_salary(target);

    }

    @RequestMapping("/wordCloud")
    public Result<ArrayList> show_word_cloud(@RequestParam("s") String s){
        String target = "20240"+s;
        return allService.show_word_cloud(target);

    }



    @RequestMapping("/cityJobTable")
    public Result<Page<City_job_table>> show_city_job_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_city_job_table(interfaceVo);

    }
    @RequestMapping("/companyPropertyTable")
    public Result<Page<Company_property_table>> show_company_property_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_company_property_table(interfaceVo);

    }
    @RequestMapping("/companyScaleTable")
    public Result<Page<Company_scale_table>> show_company_scale_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_company_scale_table(interfaceVo);

    }
    @RequestMapping("/jobPostTable")
    public Result<Page<Job_post_table>> show_job_post_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_job_post_table(interfaceVo);

    }

    @RequestMapping("/jobSalaryTable")
    public Result<Page<Job_salary_table>> show_job_salary_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_job_salary_table(interfaceVo);

    }

    @RequestMapping("/wordCloudTable")
    public Result<Page<Words_cloud>> show_word_cloud_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_word_cloud_table(interfaceVo );

    }

    @RequestMapping("/originTable")
    public Result<Page<Origindata>> show_origin_table(@RequestBody InterfaceVo interfaceVo){
        return allService.show_origin_table(interfaceVo );

    }

}
