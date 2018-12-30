<template>
  <div class='app-container'>

    <!-- Header -->

    <nav class="navbar navbar-dark bg-primary fixed-top">
      <span class="navbar-brand nav-header">
        Vue2.5.21 Project Demo
      </span>
    </nav>

    <!-- Router -->

    <router-view></router-view>

    <!-- 底部Tapbar -->
    <div class='bottom-tabbar'>
      <ul class="list-inline nav-bottom">
            <li class="list-inline-item active">
              <router-link to="/home">
              <i class="fas fa-home"></i>
              <span class="nav-link" href="#">Home</span></router-link>
            </li>
            <li class="list-inline-item">
              <router-link to="/message">
              <i class="fas fa-envelope"></i>
              <span class="nav-link" href="#">Message</span></router-link>
            </li>
            <li class="list-inline-item">
              <router-link to="/contacts">
              <i class="far fa-address-book"></i>
              <span class="nav-link" href="#">Contacts</span></router-link>
            </li>
            <li class="list-inline-item">
              <router-link to="/setting">
              <i class="fas fa-cogs"></i>
              <span class="nav-link" href="#">Setting</span></router-link>
            </li>
          </ul>
    </div>



    
  </div>
</template>

<script>

</script>

<style scoped>

div.app-container {
  padding-top: 56px;
}

span.nav-header {
  margin: 0 auto;
}

div.bottom-tabbar {
  position: fixed;
  bottom: 0;
  z-index: 1030;
  flex-shrink: 0;
  width: 100%;
  text-align: center;
}

ul.nav-bottom {
  background-color: #e3f2fd;
  margin: 0 auto;
}

ul.nav-bottom .nav-link {
    display: block;
    padding: .1rem .5rem;
}

ul.nav-bottom a {
  color : black;
}

ul.nav-bottom a.active i, ul.nav-bottom a.active span{
  color:deepskyblue;
}

ul.nav-bottom li {
  padding-top: .2em;
}


</style>

