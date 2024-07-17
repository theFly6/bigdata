

CREATE TABLE `recruit.app_recruit2_size_distribution`(
    `report_time` string COMMENT 'report_time',
    `company_size` string COMMENT 'company_size',
    `num` INT COMMENT 'num'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;