import axios from 'axios';
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useTimeStore } from './time'

export const useTableStore = defineStore('table', () => {
  const tablesData = ref({
    a: { name: "originTable", data: [] },
    b: { name: "cityJobTable", data: [] },
    c: { name: "companyScaleTable", data: [] },
    d: { name: "jobSalaryTable", data: [] },
    e: { name: "companyPropertyTable", data: [] },
    f: { name: "wordCloudTable", data: [] },
  } as {
    [key: string]: { name: string, data: [] }
  });

  const totalPage = ref(1)
  const totalElements = ref(1)
  const curPage = ref(1)
  const data = ref([])
  const timeStore = useTimeStore()
  async function getPage(tableType = 'a', page = 1) {
    data.value = []
    const res = await axios.post(`http://www.recruit.api:8081/show/${tablesData.value[tableType].name}`, {
      s: String(timeStore.time.month),
      page: page,
      size: 13
    })
    curPage.value = page
    totalElements.value = res.data.data.totalElements
    data.value = res.data.data.content
    console.log('???', res.data.data, Object.keys(data.value[0]), '???')
  }

  return { tablesData, totalPage, getPage, totalElements, data, curPage }
})
