import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// 用于菜单收起、展开功能
export const useMenuStore = defineStore('menu', () => {
  const menuIsOn = ref(1)
  if (!localStorage.getItem("menuIsOn"))
    menuIsOn.value = 1
  else
    menuIsOn.value = Number(localStorage.getItem("menuIsOn"))
  const menuMsg = computed(() => menuIsOn.value ? "收起功能菜单" : "展开功能菜单")
  function shiftMenu() {
    menuIsOn.value = 1 - menuIsOn.value
    localStorage.setItem("menuIsOn", String(menuIsOn.value))
  }

  return { menuIsOn, menuMsg, shiftMenu }
})
