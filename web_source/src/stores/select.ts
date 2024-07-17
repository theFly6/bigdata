import { defineStore } from 'pinia'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

// 用于保证输入url与左侧菜单样式同步
export const useSelectStore = defineStore('select', () => {
  const selectedMenuIndex = ref("")
  const router = useRouter()
  if (location.href.endsWith("data-board")) {
    selectedMenuIndex.value = "1"
  }
  else if (location.href.endsWith("else")) {
    selectedMenuIndex.value = "3"
  }
  else {
    selectedMenuIndex.value = location.href.slice(-1)
  }

  const handleSelect = (tableTypeID: string, keyPath: string[]) => {
    if (tableTypeID === "1")
      router.push("/data-board")
    else if (tableTypeID === "3")
      router.push("/else")
    else
      router.push({
        name: "tables",
        params: {
          tableTypeID: tableTypeID
        }
      })
    selectedMenuIndex.value = tableTypeID
  }

  return { selectedMenuIndex, handleSelect }
})
