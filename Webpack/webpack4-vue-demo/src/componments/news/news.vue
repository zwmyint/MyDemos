<template>
  <div>
    <div class="list-group news">
      <router-link :to="'/home/news/' + item.id"  v-for="(item, index) in news" :key="index" class="list-group-item list-group-item-action">
        <div class="container-fluid">
          <div class="row">
            <div class="col-2"><img src="../../images/people.jpg" alt=""></div>
            <div class="col-10">
              <h1 class="news-info">{{item.title}}</h1>
              <p class="new-detail"> <span>{{item.time | timeFilter}}</span>  <span>点击: {{item.count}}</span></p>
            </div>
          </div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
  import newsData from '../../datas/news.json';
  export default  {
    
    data: function() {
      return {
        news: []
      }
    },
    created() {
      this.getNews();
    },
    methods: {
      getNews: function() {
        this.news = newsData.news;
      }
    },

    filters: {
      timeFilter: function(data) {
        return data.substring(0, 20);
      }
    }

  }

</script>

<style scoped>
  div.news p {
    margin: 0;
    padding: 0;
  }
  div.news {
    margin-top: 2px;
    font-size: 14px;
  }

  div.news img {
    width:40px;
  }

  p.new-detail {
    display: flex;
    justify-content: space-between;
    color:darkturquoise;
  }

  .list-group-item {
      padding: .4rem 0 !important;
  }

  h1.news-info {
    font-size: 14px !important;
  }
</style>
