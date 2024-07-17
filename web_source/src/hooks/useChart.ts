import axios from 'axios';
import { ref } from 'vue'

// 用于保证输入url与左侧菜单样式同步
export default function () {
  const chartsOptions = ref(Array(6))
  chartsOptions.value[0] = {
    dataset: [
      {
        dimensions: ['dt', 'city_name', 'job_num'],
        source: []
      },
      {
        transform: {
          type: 'sort',
          config: { dimension: 'job_num', order: 'desc' }
        }
      }
    ],
    xAxis: {
      type: 'category',
      axisLabel: { interval: 0, rotate: 30 }
    },
    yAxis: {},
    series: {
      type: 'bar',
      encode: { x: 'city_name', y: 'job_num' },
      datasetIndex: 1
    }
  }

  function setCityJob(s: string) {
    axios({
      url: "http://192.168.72.24:8081/show/cityJob",
      params: { s: s },
      method: "POST"
    }).then((res: any) => {
      chartsOptions.value[0].dataset[0].source = res.data.data
      console.log("@@@", res.data.data)
    })
  }

  chartsOptions.value[1] = {
    dataset: {
      source: [
        ['score', 'amount', 'product'],
        [89.3, 58212, 'Matcha Latte'],
        [57.1, 78254, 'Milk Tea'],
        [74.4, 41032, 'Cheese Cocoa'],
        [50.1, 12755, 'Cheese Brownie'],
        [89.7, 20145, 'Matcha Cocoa'],
        [68.1, 79146, 'Tea'],
        [19.6, 91852, 'Orange Juice'],
        [10.6, 101852, 'Lemon Juice'],
        [32.7, 20112, 'Walnut Brownie']
      ]
    },
    grid: { containLabel: true },
    xAxis: { name: 'amount' },
    yAxis: { type: 'category' },
    visualMap: {
      orient: 'horizontal',
      left: 'center',
      min: 10,
      max: 100,
      text: ['High Score', 'Low Score'],
      // Map the score column to color
      dimension: 0,
      inRange: {
        color: ['#65B581', '#FFCE34', '#FD665F']
      }
    },
    series: [
      {
        type: 'bar',
        encode: {
          // Map the "amount" column to X axis.
          x: 'amount',
          // Map the "product" column to Y axis
          y: 'product'
        }
      }
    ]
  }
  chartsOptions.value[2] = {
    title: {
      text: 'Funnel',
      left: 'left',
      top: 'bottom'
    },
    grid: {
      width: "100%",
      heigth: "auto"
    },
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br/>{b} : {c}%'
    },
    toolbox: {
      orient: 'vertical',
      top: 'center',
      feature: {
        dataView: { readOnly: false },
        restore: {},
        saveAsImage: {}
      }
    },
    legend: {
      orient: 'vertical',
      left: 'left',
      data: ['Show', 'Click', 'Visit', 'Inquiry', 'Order']
    },
    series: [
      {
        name: 'Funnel',
        type: 'funnel',
        width: '60%',
        height: '70%',
        left: '20%',
        top: '15%',
        data: [
          { value: 60, name: 'Visit' },
          { value: 30, name: 'Inquiry' },
          { value: 10, name: 'Order' },
          { value: 80, name: 'Click' },
          { value: 100, name: 'Show' }
        ]
      },
    ]
  };
  chartsOptions.value[3] = {
    tooltip: {
      trigger: 'item'
    },
    legend: {
      top: '5%',
      left: 'center'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: ['40%', '70%'],
        avoidLabelOverlap: false,
        label: {
          show: false,
          position: 'center'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: false
        },
        data: [
          { value: 1048, name: 'Search Engine' },
          { value: 735, name: 'Direct' },
          { value: 580, name: 'Email' },
          { value: 484, name: 'Union Ads' },
          { value: 300, name: 'Video Ads' }
        ]
      }
    ]
  }
  chartsOptions.value[4] = {
    xAxis: {
      type: 'category',
      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line',
        smooth: true
      }
    ]
  };
  chartsOptions.value[5] = {
    title: {
      text: '词云展示',
      link: 'https://www.baidu.com/s?wd=' + encodeURIComponent('ECharts'),
      x: 'left',
      textStyle: {
        fontSize: 23,
        color: 'rgba(255, 255, 255, 0.8)'
      }

    },
    tooltip: {
      show: true
    },
    series: [{
      name: '热点分析',
      type: 'wordCloud',
      textPadding: 0,
      autoSize: {
        enable: true,
        minSize: 6
      },
      textStyle: {
        normal: {
          color: function () {
            return 'rgb(' + [
              Math.round(Math.random() * 105) + 150,
              Math.round(Math.random() * 105) + 150,
              Math.round(Math.random() * 105) + 150
            ].join(',') + ')';
          }
        },
        emphasis: {
          shadowBlur: 10,
          shadowColor: '#333'
        }
      },
      data: [{
        name: "Jayfee",
        value: 666
      }, {
        name: "Nancy",
        value: 520
      }]
    }]
  };
  var JosnList = [{
    name: "Jayfee",
    value: 666
  }, {
    name: "Nancy",
    value: 520
  }, {
    name: "生活资源",
    value: "999"
  }, {
    name: "供热管理",
    value: "888"
  }, {
    name: "供气质量",
    value: "777"
  }, {
    name: "生活用水管理",
    value: "688"
  }, {
    name: "一次供水问题",
    value: "588"
  }, {
    name: "交通运输",
    value: "516"
  }, {
    name: "城市交通",
    value: "515"
  }, {
    name: "环境保护",
    value: "483"
  }, {
    name: "房地产管理",
    value: "462"
  }, {
    name: "城乡建设",
    value: "449"
  }, {
    name: "社会保障与福利",
    value: "429"
  }, {
    name: "社会保障",
    value: "407"
  }, {
    name: "文体与教育管理",
    value: "406"
  }, {
    name: "公共安全",
    value: "406"
  }, {
    name: "公交运输管理",
    value: "386"
  }, {
    name: "出租车运营管理",
    value: "385"
  }, {
    name: "供热管理",
    value: "375"
  }, {
    name: "市容环卫",
    value: "355"
  }, {
    name: "自然资源管理",
    value: "355"
  }, {
    name: "粉尘污染",
    value: "335"
  }, {
    name: "噪声污染",
    value: "324"
  }]
  chartsOptions.value[5].series[0].data = JosnList;

  return { chartsOptions, setCityJob }
}
