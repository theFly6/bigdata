#!/bin/sh

# dwd
hive -f dwd_recruit.sql

# dim
hive -f dim_recruit.sql

# dwm
hive -f dwm_recruit1_city_job.sql
hive -f dwm_recruit3_salary_rank

# app
hive -f app_recruit1_city_job.sql
hive -f app_recruit2_size_distribution.sql
hive -f app_recruit3_salary_rank.sql
hive -f app_recruit4_property_company.sql
hive -f app_recruit5_number_employment.sql
hive -f app_recruit6_word_cloud