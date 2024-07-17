

CREATE TABLE `recruit.ods_recruit`(
    `crawl_datetime` string COMMENT 'crawl_datetime',
    `post_time` string COMMENT 'post_time',
    `url` string COMMENT 'url',
    `company_name` string COMMENT 'company_name',
    `company_size` string COMMENT 'company_size',
    `company_type` string COMMENT 'company_type',
    `job_type` string COMMENT 'job_type',
    `job_name` string COMMENT 'job_name',
    `edu` string COMMENT 'edu',
    `salary` string COMMENT 'salary',
    `people_need` string COMMENT 'people_need',
    `walfare` string COMMENT 'walfare',
    `city` string COMMENT 'city',
    `workingexp` string COMMENT 'workingexp',
    `company_area` string COMMENT 'company_area',
    `work_place` string COMMENT 'work_place',
    `require_content` string COMMENT 'require_content'
)
PARTITIONED BY (`dt` string COMMENT 'report time')
STORED AS ORC;