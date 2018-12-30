import VueRouter from 'vue-router'


import contacts from './componments/tabbar/contacts.vue'
import home from './componments/tabbar/home.vue'
import message from './componments/tabbar/message.vue'
import setting from './componments/tabbar/setting.vue'


const router = new VueRouter({
  routes: [
    { path: '/', redirect: '/home' },
    { path: '/contacts', component: contacts },
    { path: '/home', component: home },
    { path: '/message', component: message },
    { path: '/setting', component: setting }
  ],
  linkActiveClass: "active"
})

export default router;

