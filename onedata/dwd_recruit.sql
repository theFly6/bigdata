-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

insert overwrite table `recruit.dwd_recruit` partition (dt)
select 
    company_name, 
    company_size, 
    company_type, 
    job_type, 
    job_name, 
    edu,
    salary, 
    coalesce(
        cast(regexp_extract(people_need, '(\\d+)', 0) as INT),
        3
    ) as people_need,
    split(city, '-')[0] as city, 
    require_content,
    dt
from (
    select 
        company_name, 
        company_size, 
        company_type, 
        job_type, 
        job_name, 
        edu, 
        salary, 
        people_need, 
        city, 
        require_content,
        dt
    from recruit.ods_recruit
    where company_name!="company_name"
) t;

-- 查询验证
select city,job_name,company_name from recruit.dwd_recruit 
where dt = '202405' limit 3;
select city,job_name,company_name from recruit.dwd_recruit 
where dt = '202406' limit 3;
select city,job_name,company_name from recruit.dwd_recruit 
where dt = '202407' limit 3;
