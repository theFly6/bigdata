-- 设置动态分区
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE `recruit.dwm_recruit3_salary_rank_trans3` PARTITION (dt)
SELECT
  job_name,
  regexp_extract(salary, '([0-9]*\.?[0-9]+)-?([0-9]*\.?[0-9]+)', 0) AS salary_num,
  regexp_extract(salary, '([^/0-9]+)/([^/]+)', 0) AS salary_type,
  dt
FROM
  `recruit.dwd_recruit`;

-- 筛选出"千/月"以及"万/月"或"万/年"的数据
INSERT OVERWRITE TABLE `recruit.dwm_recruit3_salary_rank_trans3` PARTITION (dt)
SELECT job_name, salary_num, salary_type, dt
FROM `recruit.dwm_recruit3_salary_rank_trans3`
WHERE salary_type IN ('千/月', '万/月', '万/年')
AND salary_num LIKE '%-%';

-- 查询验证`recruit.dwm_recruit3_salary_rank_trans3`
select salary_type,salary_num,job_name
from `recruit.dwm_recruit3_salary_rank_trans3`
where dt='202401' limit 5;



-- 转储d-d格式数据到double类型数据上
INSERT INTO `recruit.dwm_recruit3_salary_rank_trans2` PARTITION (dt)
SELECT
    job_name,
    CAST(SUBSTRING_INDEX(salary_num, '-', 1) AS DOUBLE) AS min_salary,
    CAST(SUBSTRING_INDEX(salary_num, '-', -1) AS DOUBLE) AS max_salary,
    salary_type,
    dt
FROM
    `recruit.dwm_recruit3_salary_rank_trans3`;


-- 查询验证`recruit.dwm_recruit3_salary_rank_trans2`
select salary_type,min_salary,max_salary
from `recruit.dwm_recruit3_salary_rank_trans2`
where dt='202401' limit 5;

-- 根据上述salary计算权重以及每个薪水的平均值
INSERT INTO `recruit.dwm_recruit3_salary_rank_trans1` PARTITION (dt)
SELECT
    job_name,
    (min_salary+max_salary)/2 AS salary_avg,
    CASE
        WHEN salary_type = '千/月' THEN 12
        WHEN salary_type = '万/月' THEN 120
        WHEN salary_type = '万/年' THEN 10
        ELSE 0
    END AS salary_type_score,
    dt
FROM
    `recruit.dwm_recruit3_salary_rank_trans2`;

-- 将每个avg与权值进行相乘，最终单位k/年
INSERT OVERWRITE TABLE `recruit.dwm_recruit3_salary_rank_trans1` PARTITION (dt)
SELECT
    job_name,
    salary_avg*salary_type_score AS salary_avg,
    salary_type_score,
    dt
FROM
    `recruit.dwm_recruit3_salary_rank_trans1`;

-- 查询验证`recruit.dwm_recruit3_salary_rank_trans1`
select salary_avg,salary_type_score,job_name
from `recruit.dwm_recruit3_salary_rank_trans1`
where dt='202405' limit 5;
select salary_avg,salary_type_score,job_name
from `recruit.dwm_recruit3_salary_rank_trans1`
where dt='202406' limit 5;
select salary_avg,salary_type_score,job_name
from `recruit.dwm_recruit3_salary_rank_trans1`
where dt='202407' limit 5;

