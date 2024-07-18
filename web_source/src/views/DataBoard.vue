<template>
  <div class="data-board">
    <el-row>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart v-if="chartStore.chartsOptionsReady[0]" :option="chartStore.chartsOptions[0]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart v-if="chartStore.chartsOptionsReady[1]" :option="chartStore.chartsOptions[1]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple">
          <Chart v-if="chartStore.chartsOptionsReady[2]" :option="chartStore.chartsOptions[2]" />
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple grid-content-little">
          <Chart v-if="chartStore.chartsOptionsReady[3]" :option="chartStore.chartsOptions[3]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple grid-content-little">
          <Chart v-if="chartStore.chartsOptionsReady[4]" :option="chartStore.chartsOptions[4]" />
        </div>
      </el-col>
      <el-col :span="8">
        <div class="grid-content ep-bg-purple grid-content-little">
          <Chart v-if="chartStore.chartsOptionsReady[5]" :option="chartStore.chartsOptions[5]" />
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
  console.log("DataBoard onBeforeMount")
  chartStore.setAllPharagraph("1")
  console.log("DataBoard onBeforeMount", chartStore.chartsOptions[0].dataset[0].source)
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
  min-height: 300px;
}

.chart-item {
  width: 100%;
  height: 385px;
  margin: 0 auto;
  /* background-color: rgb(16, 12, 42); */
  /* background-color: #255a75; */
}

.grid-content-little .chart-item {
  width: 100%;
  height: 340px;
}
</style>