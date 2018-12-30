<template>
  <div>
    <div class="card" style="width: 100%;">
      <div class="card-header">
        上海天气
      </div>
      <div class="card-body">
        <ul class="list-group" v-for="(item, index) in weatherData" :key="index">
          <li class="list-group-item">
              <label class="btn  btn-outline-primary">
                {{item.date}}
              </label>
              <label class="btn btn-outline-secondary">
                {{item.fengli}}
              </label>
              <label class="btn btn-outline-success">
                {{item.fengxiang}}
              </label>
              <label class="btn btn-outline-danger">
                {{item.high}}
              </label>
              <label class="btn btn-outline-warning">
                {{item.low}}
              </label>
              <label class="btn btn-outline-info">
                {{item.type}}
              </label>
          </li>
        </ul>
      </div>
    </div>
    <!-- Whether End -->
    <div class='menu-container'>
      <div class="row">
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
      </div>
      <div class="row">
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
        <div class="col-4 menu">
          <p class='menu-icon'><i class="fas fa-home"></i></p>
          <span class='title'>haha</span>
        </div>
    </div>
    </div>
  </div>
  
</template>

<script>
export default {
  data: function() {
    return {
      weatherData: []
    }
  },
  created() {
    this.getWeather();
  },
  methods: {
    getWeather: function() {
      this.$http.get('https://www.apiopen.top/weatherApi?city=%E4%B8%8A%E6%B5%B7').then(result=> {
        console.log(result.status);
        if ("200" == result.status) {
          this.weatherData = result.body.data.forecast;
        }
      })
    }
  },
}
</script>

<style scoped>
div.card {
  border-radius: 0 !important;
}
div.menu-container {
  margin: 4px auto 0 auto;
}
div p.menu-icon {
  margin-bottom: 0 !important;
  font-size: 2.2rem !important;
}
</style>
