<template>

  <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" :default-openeds="['2']"
    :default-active="selectedMenuIndex" text-color="#fff" :collapse="!menuStore.menuIsOn" @select="handleSelect">
    <template v-if="!menuStore.menuIsOn">
      <el-menu-item>
        <el-icon>
          <Lock />
        </el-icon>
      </el-menu-item>
    </template>
    <template v-else>
      <h3>功能菜单</h3>
    </template>
    <el-menu-item index="1">
      <el-icon>
        <View />
      </el-icon>
      <span>数据看板</span>
    </el-menu-item>

    <el-sub-menu index="2">
      <template #title>
        <el-icon>
          <Grid />
        </el-icon>
        <span>数据表格</span>
      </template>
      <el-menu-item index="a">原始招聘数据</el-menu-item>
      <el-menu-item index="b">城市职位需求</el-menu-item>
      <el-menu-item index="c">公司规模数据</el-menu-item>
      <el-menu-item index="d">工资排行数据</el-menu-item>
      <el-menu-item index="e">公司性质数据</el-menu-item>
      <el-menu-item index="f">词云频率统计</el-menu-item>
    </el-sub-menu>

    <el-menu-item index="3">
      <el-icon>
        <setting />
      </el-icon>
      <span>其它功能</span>
    </el-menu-item>
  </el-menu>
</template>

<script lang="ts" setup>
import useSelect from '@/hooks/useSelect';
import {
  Grid,
  View,
  Setting,
  Lock
} from '@element-plus/icons-vue'
import { ref } from 'vue';

import { useMenuStore } from '@/stores/menu';

const { handleSelect, selectedMenuIndex } = useSelect()
const menuStore = useMenuStore()

</script>


<style scoped>
.el-menu {
  height: 100%;
}

.el-menu h3 {
  color: #fff;
  text-align: center;
  margin-left: -10px;
  line-height: 48px;
  font-size: 16px;
  font-weight: 600;
  white-space: nowrap;
  overflow: hidden;
}

.el-sub-menu {
  transition: 1s all linear;
}

h3 .el-icon {
  margin-left: 50%;
  margin-top: 50%;
  transform: translate(-50%, -50%);
}
</style>