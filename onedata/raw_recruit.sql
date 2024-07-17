

-- 链接202401数据集
alter table recruit.raw_recruit
add if not exists partition (dt='${DT}')
location 'hdfs://hadoop1:9090/home/recruit/${DT}';

-- 验证查询语句
-- select * from raw_recruit where dt='202401' limit 4;