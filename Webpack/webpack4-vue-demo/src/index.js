import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import "./css/index.css"

import Vue from 'vue'
//导入路由的包
import VueRouter from 'vue-router'
//注册路由的包
Vue.use(VueRouter)


import router from './router.js'
import app from './app.vue'

var vm = new Vue({
  el: '#app',
  data: {
    msg: 'Vue-v2.5.21 based webpack4.'
  },
  render: (c) => c(app),  //c-> createElement
  router: router  //挂载路由到app实例上

  
  
});

