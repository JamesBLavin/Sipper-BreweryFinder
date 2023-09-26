<template>
  <div class="brewery-card">
    <h2>{{brewery.brewery_name}}</h2>
    <img :src="brewery.brewery_img_url" alt="dust" id="previewpics"/>
  </div>
</template>

<script>
export default {
    name: "brewery-card",
    props: {
      brewery: Object
    }
    }

</script>

<style scoped>
.brewery-card:hover {
  color: peru;
}

#previewpics {
  width: 65px;
}

.brewery-card {
  display: flex;
  /* border-top: solid white 5px;
  border-bottom: solid white 5px; */
  border: solid orange 2px;
  border-radius: 5% / 50%;
  justify-content: space-between;
}

h2 {
  margin-left: 20px;
}

.brewery-card {
  margin-bottom: 50px;
}
</style>