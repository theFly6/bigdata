-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

-- 求得salary数据的平均值并存入最终的结果
INSERT OVERWRITE TABLE `recruit.app_recruit3_salary_rank` PARTITION (dt)
SELECT dt as report_time, job_name, AVG(salary_avg) as salary_avg, dt
FROM `recruit.dwm_recruit3_salary_rank_trans1`
GROUP BY job_name, dt
ORDER BY salary_avg DESC;

-- 验证语句
select salary_avg,job_name
from `recruit.app_recruit3_salary_rank`
where dt='202401' limit 5;