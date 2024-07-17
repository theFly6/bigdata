
CREATE TABLE `recruit.app_recruit`(
    `report_time` string COMMENT 'report_time',
    `company_name` string COMMENT 'company_name',
    `company_size` string COMMENT 'company_size',
    `company_type` string COMMENT 'company_type',
    `job_type` string COMMENT 'job_type',
    `job_name` string COMMENT 'job_name',
    `edu` string COMMENT 'edu',
    `salary` string COMMENT 'salary',
    `people_need` INT DEFAULT 3 COMMENT 'people_need',
    `city` string COMMENT 'city',
    `require_content` string COMMENT 'require_content'
)
PARTITIONED BY (`dt` string COMMENT 'report time')
STORED AS ORC;

INSERT OVERWRITE TABLE `recruit.app_recruit` PARTITION (dt)
SELECT 
    dt as report_time, 
    company_name,
    company_size, 
    company_type,
    job_type,
    job_name,
    edu,
    salary,
    people_need,
    city,
    require_content,
    dt
FROM
    `recruit.dwd_recruit`;