<template>
  <div class="tables">
    <Table></Table>
  </div>
</template>

<script lang="ts" setup>
import router from "@/router";
import Table from "@/components/Table.vue"
console.log(`这是tables${JSON.stringify(router.currentRoute.value.params)}`)

</script>

<style scoped>
.tables {
  width: 80%;
  margin: 0 auto;
  margin-top: 2%;
}
</style>