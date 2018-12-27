import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import "./css/index.css"

import Vue from 'vue'


import app from './app.vue'

var vm = new Vue({
  el: '#app',
  data: {
    msg: 'Vue-v2.5.21 based webpack4.'
  },
  render: (c) => c(app)  //c-> createElement
   
});

