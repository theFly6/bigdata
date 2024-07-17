
-- 用于存储每个城市招聘数量的app表
CREATE TABLE `recruit.dim_city_list`(
    `city` string COMMENT 'city'
)
STORED AS TEXTFILE;