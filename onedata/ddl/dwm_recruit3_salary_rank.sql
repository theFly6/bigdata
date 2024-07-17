

CREATE TABLE `recruit.dwm_recruit3_salary_rank_trans1`(
    `job_name` string COMMENT 'job_name',
    `salary_avg` DOUBLE COMMENT 'salary_avg',
    `salary_type_score` INT  COMMENT 'salary_type_score scall times'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;

CREATE TABLE `recruit.dwm_recruit3_salary_rank_trans2`(
    `job_name` string COMMENT 'job_name',
    `min_salary` DOUBLE COMMENT 'min_salary',
    `max_salary` DOUBLE COMMENT 'max_salary',
    `salary_type` string COMMENT 'salary_type'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;

CREATE TABLE `recruit.dwm_recruit3_salary_rank_trans3`(
    `job_name` string COMMENT '职位名称',
    `salary_num` string COMMENT '薪资范围',
    `salary_type` string COMMENT '薪资类型'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;