-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;


INSERT OVERWRITE TABLE `recruit.app_recruit4_property_company` PARTITION (dt)
SELECT
    dt AS report_time,
    COUNT(DISTINCT CASE WHEN company_type = '国企' THEN company_name ELSE NULL END) AS guoqi,
    COUNT(DISTINCT CASE WHEN company_type = '民营公司' THEN company_name ELSE NULL END) AS minying_count,
    COUNT(DISTINCT CASE WHEN company_type like '%外资%' THEN company_name ELSE NULL END) AS waizi,
    COUNT(DISTINCT CASE WHEN company_type = '合资' THEN company_name ELSE NULL END) AS hezi,
    COUNT(DISTINCT CASE WHEN company_type = '上市公司' THEN company_name ELSE NULL END) AS shangshi,
    COUNT(DISTINCT CASE WHEN company_type = '创业公司' THEN company_name ELSE NULL END) AS chuangye,
    COUNT(DISTINCT CASE WHEN company_type = '事业单位' THEN company_name ELSE NULL END) AS shiyedanwei,
    dt
FROM
    `recruit.dwd_recruit`
GROUP BY
    dt;


-- 验证语句
select * 
from `recruit.app_recruit4_property_company`;