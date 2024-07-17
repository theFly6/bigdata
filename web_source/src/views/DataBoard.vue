<template>
  <div class="data-board">
    <el-row>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[0]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[1]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[2]" />
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[3]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[4]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart :option="chartStore.chartsOptions[5]" />
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, onBeforeMount } from "vue"
import Chart from "@/components/Chart.vue";

import { useChartStore } from '@/stores/chart';

const chartStore = useChartStore()

onBeforeMount(() => {
  chartStore.setCityJob("1")
  console.log("DataBoard onMounted", chartStore.chartsOptions[0].dataset[0].source)
})

</script>

<style scoped>
.el-row {
  margin: 0;
}

.el-col {
  border-radius: 4px;
  margin: 0;
  padding: 0px;
}

.grid-content {
  border-radius: 4px;
  min-height: 340px;
}
</style>