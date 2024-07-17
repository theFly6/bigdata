

CREATE TABLE `recruit.app_recruit5_number_employment`(
    `report_time` string COMMENT 'report_time',
    `job_number` bigint COMMENT 'job_number'
)
COMMENT 'app job number'
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;