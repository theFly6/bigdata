

CREATE TABLE `recruit.app_recruit3_salary_rank`(
    `report_time` string COMMENT 'report_time',
    `job_name` string COMMENT 'job_name',
    `salary_avg` DOUBLE COMMENT 'salary_avg'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;