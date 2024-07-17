-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE `recruit.app_recruit1_city_job` PARTITION (dt)
SELECT dt as report_time, city, SUM(job_num) AS job_num, dt
FROM `recruit.dwm_recruit1_city_job`
GROUP BY city, dt;

-- 验证语句
select report_time, job_num, city
from `recruit.app_recruit1_city_job`
where dt="202406" limit 3;