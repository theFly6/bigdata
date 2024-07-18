<template>
  <el-row>
    <el-col :sm="24" :lg="24">
      <el-result icon="success" title="更多功能正在开发" sub-title="More features are being developed">
        <template #extra>
          <el-button type="primary" @click="toHome">
            返回首页
          </el-button>
        </template>
      </el-result>
    </el-col>
  </el-row>
</template>


<script lang="ts" setup name="">
import { ref, reactive } from "vue"
import { useRouter } from 'vue-router'
const router = useRouter()
function toHome() {
  router.push("/data-board")
}
</script>

<style scoped></style>