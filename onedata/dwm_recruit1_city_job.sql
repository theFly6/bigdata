-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE `recruit.dwm_recruit1_city_job` partition (dt)
SELECT city, SUM(people_need) AS job_num, dt
FROM `recruit.dwd_recruit`
GROUP BY city, dt;

insert overwrite table `recruit.dwm_recruit1_city_job` partition (dt)
SELECT 
    a.city,
    COALESCE(b.job_num, 0) AS job_num,
    dt
FROM 
    `recruit.dim_city_list` a
LEFT JOIN 
    `recruit.dwm_recruit1_city_job` b
ON 
    a.city LIKE CONCAT('%', b.city, '%');


-- 验证语句
select job_num, city
from `recruit.dwm_recruit1_city_job`
where dt="202406" limit 5;