
CREATE TABLE `recruit.app_recruit4_property_company`(
    `report_time` string COMMENT 'report_time',
    `guoqi` bigint COMMENT 'guoqi',
    `minying` bigint COMMENT 'minying',
    `waizi` bigint COMMENT 'waizi',
    `hezi` bigint COMMENT 'hezi',
    `shangshi` bigint COMMENT 'shangshi',
    `chuangye` bigint COMMENT 'chuangye',
    `shiyedanwei` bigint COMMENT 'shiyedanwei'
)
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;