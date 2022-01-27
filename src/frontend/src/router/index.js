import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import BoardList from "../components/BoardList.vue"

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/',
    name: 'List',
    component: BoardList
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router