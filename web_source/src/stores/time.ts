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
  watch(time, () => {
    chartStore.chartsOptionsReady.fill(false)
    const tableTypeID = localStorage.getItem("tableTypeID") as string
    if (tableTypeID == '1')
      chartStore.setAllPharagraph(`${time.month}`)
    else if (tableTypeID == '3') {
      // ...
    } else {
      tableStore.getPage(tableTypeID)
    }
  })
  return { time, timeMsg, setTime }
})
