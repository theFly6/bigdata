<template>
  <div class="chart-item" ref="chartDom">
  </div>
</template>

<script lang="ts" setup>
// https://echarts.apache.org/examples/zh/editor.html?c=data-transform-sort-bar
import { ref, reactive, onMounted, onUnmounted, nextTick } from 'vue';
import * as echarts from 'echarts';
import "echarts-wordcloud"

// 创建一个响应式引用来保存DOM元素
const chartDom = ref(null);
let chartInstance = null;
const props = defineProps(['option'])
const option = ref(props.option)

onMounted(async () => {
  chartInstance = echarts.init(chartDom.value, 'dark')
  console.log("???", props.option)
  option && chartInstance.setOption(option.value)
})


</script>

<style scoped>
.chart-item {
  width: 100%;
  height: 400px;
  margin: 0 auto;
  background-color: rgb(16, 12, 42);
}

.chart-item div {
  margin: 0 auto !important;
}
</style>