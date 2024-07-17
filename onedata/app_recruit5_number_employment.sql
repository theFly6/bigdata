-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE `recruit.app_recruit5_number_employment` PARTITION (dt)
SELECT
    dt as report_time,
    COUNT(*) AS job_number,
    dt
FROM
    `recruit.dwd_recruit`
GROUP BY
    dt;

select * 
from `recruit.app_recruit5_number_employment`;