import VueRouter from 'vue-router'


import contacts from './componments/tabbar/contacts.vue'
import home from './componments/tabbar/home.vue'
import message from './componments/tabbar/message.vue'
import setting from './componments/tabbar/setting.vue'
import news from './componments/news/news.vue'
import newsInfo from './componments/news/news-info.vue'


const router = new VueRouter({
  routes: [
    { path: '/', redirect: '/home' },
    { path: '/contacts', component: contacts },
    { path: '/home', component: home },
    { path: '/message', component: message },
    { path: '/setting', component: setting },
    { path: '/home/news', component: news },
    { path: '/home/news/:id', component: newsInfo }
  ],
  linkActiveClass: "active"
})

export default router;

