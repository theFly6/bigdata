insert overwrite table `recruit.ods_recruit` partition (dt='${DT}')
select
    items[0] as crawl_datetime,
    items[1] as post_time,
    items[2] as url,
    items[3] as company_name,
    items[4] as company_size,
    items[5] as company_type,
    items[6] as job_type,
    items[7] as job_name,
    items[8] as edu,
    items[9] as salary,
    items[10] as people_need,
    items[11] as walfare,
    items[12] as city,
    items[13] as workingexp,
    items[14] as company_area,
    items[15] as work_place,
    items[16] as require_content
from (
    select split(content,',') as items
    from recruit.raw_recruit
    where dt = '${DT}'
) t;

-- 查询验证
select job_name,city 
from `recruit.ods_recruit`
where dt = '202405' limit 7;