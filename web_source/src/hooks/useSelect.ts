import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useTableStore } from '@/stores/table'

// 用于保证输入url与左侧菜单样式同步
export default function () {
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

  const tableStore = useTableStore()

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
    localStorage.setItem("tableTypeID", tableTypeID)
    tableStore.getPage(tableTypeID)
  }

  return { selectedMenuIndex, handleSelect }
}
