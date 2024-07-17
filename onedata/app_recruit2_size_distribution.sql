-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;



INSERT OVERWRITE TABLE `recruit.app_recruit2_size_distribution` PARTITION (dt)
SELECT dt as report_time, company_size, count(DISTINCT company_name) as num, dt
FROM `recruit.dwd_recruit`
WHERE company_size LIKE '%人%'
GROUP BY company_size, dt;

-- 验证语句
select report_time,company_size,num
from `recruit.app_recruit2_size_distribution` 
where dt='202406' limit 5;