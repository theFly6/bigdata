<template>
  <el-container>
    <el-aside width="auto">
      <AsideVue />
    </el-aside>
    <el-aside width="auto">
      <AsideVue />
    </el-aside>
    <el-main class="main">
      <el-container>
        <el-header>
          <HeaderVue />
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-main>
  </el-container>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { ref } from 'vue'
import HeaderVue from '@/components/Header.vue';
import AsideVue from '@/components/Aside.vue';

</script>

<style scoped>
/* .main {
  background-color: #031017;
} */

.el-aside {
  overflow: hidden;
}

.el-aside:nth-child(1) {
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
  z-index: 3;
}

.el-aside:nth-child(2) {
  position: relative;
  visibility: hidden;
}

.el-header {
  padding: 0;
  margin: 0;
}

.el-main {
  padding: 0;
}

.el-container {
  height: 100%;
  margin: 0;
  padding: 0;
}
</style>