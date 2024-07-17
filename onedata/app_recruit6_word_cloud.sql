-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE `recruit.app_recruit6_word_cloud` PARTITION (dt)
SELECT
    dt as report_time,
    SUM(CASE WHEN edu = '大专' THEN 1 ELSE 0 END) AS junior_college,
    SUM(CASE WHEN edu = '本科' THEN 1 ELSE 0 END) AS bachelor,
    SUM(CASE WHEN edu = '硕士' THEN 1 ELSE 0 END) AS master,
    SUM(CASE WHEN edu = '博士' THEN 1 ELSE 0 END) AS doctor,
    SUM(CASE WHEN edu = '不限' THEN 1 ELSE 0 END) AS buxian,
    SUM(CASE WHEN edu = '无学历要求' THEN 1 ELSE 0 END) AS no_require,
    SUM(CASE WHEN edu = '初中及以下' THEN 1 ELSE 0 END) AS below_junior_high_school,
    SUM(CASE WHEN edu= '中技' THEN 1 ELSE 0 END) AS technical_secondary_school,
    SUM(CASE WHEN edu = '中专' THEN 1 ELSE 0 END) AS zhongzhuan,
    SUM(CASE WHEN edu = '高中' THEN 1 ELSE 0 END) AS gaozhong,
    dt
FROM
    `recruit.dwd_recruit`
GROUP BY
    dt;

select * 
from `recruit.app_recruit6_word_cloud`;