<template>
  <template v-if="tableStore.data.length != 0">
    <el-table :border="true" :data="tableStore.data" style="width: 100%;" max-height="550"
      :row-style="{ height: '20px' }">
      <!-- <el-table-column prop="dt" label="Dt" />
    <el-table-column prop="cityName" label="CityName" />
    <el-table-column prop="jobNum" label="JobNum" /> -->
      <template v-for="colname in Object.keys(tableStore.data[0])">
        <el-table-column min-width="140" v-if="!exceptionLabel.includes(colname)" :prop="colname"
          :label="colname.slice(0, 1).toUpperCase() + colname.slice(1)" />
      </template>
    </el-table>
    <el-pagination :current-page="tableStore.curPage" background layout="prev, pager, next"
      :total="tableStore.totalElements" @current-change="getPageNum" />
  </template>




</template>

<script lang="ts" setup>
import { onBeforeMount, ref } from 'vue';
import { useTableStore } from '@/stores/table';

const exceptionLabel = ["dt", "time", 'id', 'require_content']

const tableStore = useTableStore()
onBeforeMount(() => {
  console.log(`onBeforeMount`)
  getPageNum(1)
})
const curPage = ref(1)

function getPageNum(n: number) {
  const tableTypeID = localStorage.getItem("tableTypeID") || "a"
  console.log(tableTypeID, n)
  curPage.value = n
  tableStore.getPage(tableTypeID, n)
}

</script>


<style scoped>
.el-pagination {
  width: 300px;
  margin-top: 20px;
}

.el-table .cell {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  height: 30px !important;
  line-height: 30px;
}
</style>
