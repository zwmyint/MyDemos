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

<nav class="navbar navbar-expand-sm navbar-light bg-light fixed-bottom">
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav nav-bottom">
      <li class="nav-item active">
        <a class="nav-link" href="#"><i class="fas fa-home"></i>Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fas fa-envelope"></i>Message</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="far fa-address-book"></i>Contacts</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fas fa-cogs"></i>Setting</a>
      </li>
    </ul>
  </div>
</nav>
    
  </div>
</template>

<script>

</script>

<style scoped>
div.app-container {
  padding-top: 56px;
}

span.nav-header, ul.nav-bottom {
  margin: 0 auto;
}


</style>

