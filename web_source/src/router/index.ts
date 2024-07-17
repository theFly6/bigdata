import { createRouter, createWebHistory } from 'vue-router'
import Main from '../views/Main.vue'
import DataBoard from '../views/DataBoard.vue'
import Tables from '../views/Tables.vue'
import Else from '../views/Else.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: 'main', path: '/', component: Main, redirect: '/data-board',
      children: [
        { name: 'home', path: '/data-board', component: DataBoard },
        { name: 'tables', path: '/tables/:tableTypeID', component: Tables },
        { name: 'else', path: '/else', component: Else },
      ]
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => { }
    }
  ]
})

export default router
