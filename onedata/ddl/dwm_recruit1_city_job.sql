
-- 创建一个表来存储每个城市的people_need总和
CREATE TABLE `recruit.dwm_recruit1_city_job`(
    `city` string COMMENT 'city',
    `job_num` INT COMMENT 'num'
)
PARTITIONED BY (`dt` string COMMENT 'report time')
STORED AS ORC;