//import bootstrap style
import 'bootstrap/dist/css/bootstrap.min.css'

//Import font-awesome
import '@fortawesome/fontawesome-free/css/all.css'

//Custom css
import "./css/index.css"

//Import vue - Style-1
//这个是runtime only的包，不能编译
//import Vue from 'vue'

//这种方式导入最全的vue的包，但是不推荐这么使用！！！！ Style-1
//import Vue from 'vue/dist/vue.common.dev'

//Import vue Style-3, 在webpack.config.js 配置resolve，指定vue的别名。 但是不推荐这么使用！！！！

//推荐使用runtime的包，结合Vue render函数
import Vue from 'vue'

//Import login.vue

import login from './login.vue'

var vm = new Vue({
  el: '#app',
  data: {
    msg: 'Vue-v2.5.21 based webpack4.'
  },
  render: (c) => c(login)  //c-> createElement
   
});

