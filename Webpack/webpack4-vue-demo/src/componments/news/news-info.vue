<template>
  <div>
    News Detail -- {{id}}
  </div>
</template>

<script>
export default {
  data: function() {
    return {
     id: this.$route.params.id
    }
  },

  methods: {
    getNewsInfo: function(id) {
      // Get New Info by Id
      // Update count;
    }
  },
}
</script>

<style scoped>

</style>
