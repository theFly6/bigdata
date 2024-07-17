

CREATE TABLE `recruit.app_recruit6_word_cloud`(
    `report_time` string COMMENT 'report_time',
    `junior_college` int COMMENT '大专及以上数',
    `bachelor` int COMMENT '本科数',
    `master` int COMMENT '硕士数',
    `doctor` int COMMENT '博士数',
    `buxian` int COMMENT '不限学历数',
    `no_require` int COMMENT '无学历要求数',
    `below_junior_high_school` int COMMENT '初中及以下数',
    `technical_secondary_school` int COMMENT '中技数',
    `zhongzhuan` int COMMENT '中专数',
    `gaozhong` int COMMENT '高中数'
)
COMMENT 'app recruit education requirement'
PARTITIONED BY (`dt` string COMMENT '日期分区')
STORED AS ORC;
