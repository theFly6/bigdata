

CREATE EXTERNAL TABLE `recruit.raw_recruit`(
  `content` string COMMENT 'data content'
)
PARTITIONED BY (`dt` string COMMENT 'report time')
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\u0001'
LOCATION 'hdfs://hadoop1:9090/home/recruit/logs';