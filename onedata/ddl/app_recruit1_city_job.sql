

CREATE TABLE `recruit.app_recruit1_city_job`(
    `report_time` string COMMENT 'report_time',
    `city` string COMMENT 'city',
    `job_num` INT COMMENT 'num'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;