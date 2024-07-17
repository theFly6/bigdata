import { computed, reactive } from 'vue'
import { defineStore } from 'pinia'

export const useTimeStore = defineStore('time', () => {
  let time = reactive({
    year: 2024,
    month: 1
  })
  const timeMsg = computed(() => `${time.year}年${time.month}月份报表信息`)
  function setTime(month: number, year = 2024) {
    Object.assign(time, { year, month })
  }
  return { time, timeMsg, setTime }
})
