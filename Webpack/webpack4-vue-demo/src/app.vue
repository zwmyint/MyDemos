<template>
  <div class='app-container'>

    <!-- Header -->

    <nav class="navbar navbar-dark bg-primary fixed-top">
      <span class="navbar-brand nav-header">
        Vue2.5.21 Project Demo
      </span>
    </nav>

    <!-- Router -->

    <!-- 底部Tapbar -->
    <div class='bottom-tabbar'>
      <ul class="list-inline nav-bottom">
            <li class="list-inline-item active">
              <i class="fas fa-home"></i>
              <a class="nav-link" href="#">Home</a>
            </li>
            <li class="list-inline-item">
              <i class="fas fa-envelope"></i>
              <a class="nav-link" href="#">Message</a>
            </li>
            <li class="list-inline-item">
              <i class="far fa-address-book"></i>
              <a class="nav-link" href="#">Contacts</a>
            </li>
            <li class="list-inline-item">
              <i class="fas fa-cogs"></i>
              <a class="nav-link" href="#">Setting</a>
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


</style>

