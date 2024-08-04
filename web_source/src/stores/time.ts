import { computed, reactive, watch } from 'vue'
import { defineStore } from 'pinia'
import { useChartStore } from './chart'
import { useTableStore } from './table'

export const useTimeStore = defineStore('time', () => {
  let time = reactive({
    year: 2024,
    month: 1
  })
  const timeMsg = computed(() => `${time.year}年${time.month}月份报表信息`)
  function setTime(month: number, year = 2024) {
    Object.assign(time, { year, month })
  }

  const chartStore = useChartStore()
  const tableStore = useTableStore()
  watch(time, () => { // 对用户选择查看的数据的时间进行监视
    chartStore.chartsOptionsReady.fill(false)
    const tableTypeID = localStorage.getItem("tableTypeID") as string
    if (tableTypeID == '1') // 如果当前是可视化看板则同步看板数据
      chartStore.setAllPharagraph(`${time.month}`)
    else if (tableTypeID == '3') {
      // 如果是其它页面则进行其它操作
    } else {
      // 当前页面为表格页面时即获取此页面指定时间对应的指定数据
      const page = Number(localStorage.getItem("pageNum")) || 1
      tableStore.getPage(tableTypeID, page)
    }
  })
  return { time, timeMsg, setTime }
})
