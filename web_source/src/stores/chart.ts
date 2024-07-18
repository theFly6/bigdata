import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue'

// 用于保证输入url与左侧菜单样式同步
export const useChartStore = defineStore('chart', () => {
  const chartsOptions = ref(Array(6))
  const chartsOptionsReady = ref(Array(6).fill(false))
  chartsOptions.value[0] = {
    title: {
      text: "城市职位排行Top10",
      x: "center",
      top: "5%",
      textStyle: {
        color: "#255a75"
      }
    },
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
    grid: {
      left: "15%"
    },
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

  async function getP1(s: string) {
    const res1 = await axios({
      url: "http://www.recruit.api:8081/show/cityJob",
      params: { s },
      method: "POST"
    })
    chartsOptions.value[0].dataset[0].source = res1.data.data
    chartsOptionsReady.value[0] = true
    console.log("1 cityjob done!")
  }

  chartsOptions.value[1] = {
    title: {
      text: "公司规模分析",
      x: "center",
      top: "5%",
      textStyle: {
        color: "#255a75"
      }
    },
    dataset: {
      source: []
    },
    grid: { containLabel: true },
    xAxis: { name: '' },
    yAxis: { type: 'category' },
    visualMap: {
      show: false,
      orient: 'horizontal',
      bottom: "7%",
      left: 'center',
      min: 10,
      max: 100,
      text: ['High Score', 'Low Score'],
      dimension: 0,
      inRange: {
        color: ['#65B581', '#FFCE34', '#FD665F']
      }
    },
    series: [
      {
        type: 'bar',
        encode: {
          x: 'scale_num',
          y: 'scale_type'
        }
      }
    ]
  }
  async function getP2(s: string) {
    const res2 = await axios({
      url: "http://www.recruit.api:8081/show/companyScale",
      params: { s: s },
      method: "POST"
    })
    chartsOptions.value[1].dataset.source = [["score", "scale_num", "scale_type"]]
    res2.data.data.map((v: any,) => {
      const tmp = [Number((Math.random() * 90).toFixed(3) + 10), v[2], v[1]]
      chartsOptions.value[1].dataset.source.push(tmp)
    })
    chartsOptionsReady.value[1] = true
    console.log("2 companysize done!")
  }

  chartsOptions.value[2] = {
    title: {
      text: "职位薪资排行",
      left: "30%",
      top: "5%",
      textStyle: {
        color: "#255a75"
      }
    },
    grid: {
      width: "100%",
      heigth: "auto"
    },
    legend: {
      show: false,
      orient: 'vertical',
      bottom: "10%",
      left: '10%',
      // data: ['Show', 'Click', 'Visit', 'Inquiry', 'Order']
    },
    series: [
      {
        name: 'Funnel',
        type: 'funnel',
        width: '60%',
        height: '75%',
        left: '10%',
        top: '18%',
        data: []
      },
    ]
  };
  async function getP3(s: string) {
    const res3 = await axios({
      url: "http://www.recruit.api:8081/show/jobSalary",
      params: { s: s },
      method: "POST"
    })
    chartsOptions.value[2].series[0].data = []
    res3.data.data.map((v: any) => {
      chartsOptions.value[2].series[0].data.push({
        name: v[1],
        value: v[2]
      })
    })
    chartsOptionsReady.value[2] = true
    console.log("3 jobsalary done!")
  }

  // https://echarts.apache.org/examples/zh/editor.html?c=pie-doughnut&version=5.5.1
  chartsOptions.value[3] = {
    tooltip: {
      trigger: 'item'
    },
    legend: {
      // data: ['国企', '民营', '外资', '合资', '上市', '创业', '事业单位'],
      bottom: '10%',
      left: 'center'
    },
    title: {
      text: "公司性质分析",
      x: "center",
      textStyle: {
        color: "#255a75"
      }
    },
    series: [
      {
        top: "-20%",
        left: "center",
        name: '公司性质分析表',
        type: 'pie',
        width: "60%",
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
          { value: 1, name: '国企' },
          { value: 1, name: '民营' },
          { value: 1, name: '外资' },
          { value: 1, name: '合资' },
          { value: 1, name: '上市' },
          { value: 1, name: '创业' },
          { value: 1, name: '事业单位' },
        ]
      }
    ]
  };
  async function getP4(s: string) {
    const res4 = await axios({
      url: "http://www.recruit.api:8081/show/companyProperty",
      params: { s: s },
      method: "POST"
    })
    console.log('@@@4', chartsOptions.value[3].series[0].data)
    res4.data.data[0].slice(1, -1).map((v: number, i: number) => {
      chartsOptions.value[3].series[0].data[i].value = v
    })
    chartsOptionsReady.value[3] = true
    console.log("4 companyproperty done!")
  }

  chartsOptions.value[4] = {
    title: {
      text: "近期职位发布数量分析",
      x: "center",
      textStyle: {
        color: "#255a75"
      }
    },
    xAxis: {
      type: 'category',
      data: []
    },
    yAxis: {
      type: 'value'
    },
    grid: {
      left: "center",
      height: "60%",
      width: "60%"
    },
    series: [
      {
        data: [],
        type: 'line',
        smooth: true
      }
    ]
  };
  async function getP5(s: string) {
    const res5 = await axios({
      url: "http://www.recruit.api:8081/show/jobPost",
      params: { s },
      method: "POST"
    })
    chartsOptions.value[4].series[0].data = []
    chartsOptions.value[4].xAxis.data = []
    res5.data.data.map((v: any, i: number) => {
      chartsOptions.value[4].series[0].data.push(v[1])
      chartsOptions.value[4].xAxis.data.push(v[0])
    })
    chartsOptionsReady.value[4] = true
    console.log("5 jobPost done!")
  }

  chartsOptions.value[5] = {
    title: {
      text: '职位学历要求词云',
      link: 'https://www.baidu.com/s?wd=' + encodeURIComponent('ECharts'),
      x: 'center',
      textStyle: {
        color: '#255a75'
      }
    },
    tooltip: {
      show: true
    },
    series: [{
      name: '热点分析',
      type: 'wordCloud',
      shape: 'circle',
      textPadding: 5,
      sizeRange: [20, 60],
      textStyle: {
        color: function () {
          return 'rgb(' + [
            Math.round(Math.random() * 155),
            Math.round(Math.random() * 155),
            Math.round(Math.random() * 155)
          ].join(',') + ')';
        },
        emphasis: {
          shadowBlur: 3,
          shadowColor: '#333'
        }
      },
      data: []
    }]
  }
  async function getP6(s: string) {
    const res6 = await axios({
      url: "http://www.recruit.api:8081/show/wordCloud",
      params: { s: s },
      method: "POST"
    })
    const jobs = ["大专", "学士", "硕士", "博士", "无学历要求", "不限", "初中及以下", "中技", "中专", "高中"]
    chartsOptions.value[5].series[0].data = []
    res6.data.data[0].slice(0, -1).map((v: any, i: number) => {
      chartsOptions.value[5].series[0].data.push({
        name: jobs[i],
        value: v
      })
    })
    chartsOptionsReady.value[5] = true
    console.log("6 wordcloud done!")
  }
  function setAllPharagraph(s: string) {
    getP1(s)
    getP2(s)
    getP3(s)
    getP4(s)
    getP5(s)
    getP6(s)
  }
  return { chartsOptions, setAllPharagraph, chartsOptionsReady }
})
