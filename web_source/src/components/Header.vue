<template>

  <el-menu class="el-menu-demo" mode="horizontal" background-color="#545c64" text-color="#fff"
    active-text-color="#ffd04b" @select="handleSelect" :default-active="'1'">
    <el-button @click="menuStore.shiftMenu">
      <el-icon>
        <Switch />
      </el-icon>
      <span>{{ menuStore.menuMsg }}</span>
    </el-button>
    <h1 class="title">基于Hadoop+Hive的计算机类招聘职位大数据分析平台</h1>
    <el-sub-menu index="0">
      <template #title>{{ timeStore.timeMsg }}</template>
      <el-sub-menu index="2024">
        <template #title>2024年</template>
        <template v-for="i in 12" :key="i">
          <el-menu-item :index="String(i)" :disabled="i > new Date().getMonth() + 1">{{ i }}月</el-menu-item>
        </template>
      </el-sub-menu>
      <el-menu-item index="2023" :disabled="true">2023年</el-menu-item>
      <el-menu-item index="2022" disabled>2022年</el-menu-item>
      <el-menu-item index="2021" disabled>2021年</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import {
  Switch
} from '@element-plus/icons-vue'
import { useMenuStore } from '@/stores/menu';
import { useTimeStore } from '@/stores/time';

const menuStore = useMenuStore()
const timeStore = useTimeStore()

const handleSelect = (key: string, keyPath: string[]) => {
  timeStore.setTime(Number(keyPath[2]), Number(keyPath[1]))
}
</script>

<style scoped>
.menu {
  width: 205px;
}

.el-menu {
  justify-content: space-between;
}

.el-button {
  background-color: rgb(84, 92, 100);
  color: white;
  height: 100%;
  border: 0;
}

.el-button:hover {
  color: white;
  background-color: rgb(67, 74, 80);
}

span {
  padding-left: 5px;
}

.title {
  color: white;
  height: 100%;
  line-height: 59px;
  font-weight: 400;
  font-size: 20px;
}
</style>
