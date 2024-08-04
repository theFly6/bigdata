<template>
  <div class="chart-item" ref="chartDom">
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, onMounted } from 'vue';
import * as echarts from 'echarts';
import "echarts-wordcloud"
// 创建一个响应式引用来保存DOM元素
const chartDom = ref(null);
let chartInstance = null;
const props = defineProps(['option'])
const option = ref(props.option)
onMounted(() => {
  chartInstance = echarts.init(chartDom.value)
  // console.log("Chart onMounted", JSON.stringify(option.value))
  option && chartInstance.setOption(option.value)
})
</script>