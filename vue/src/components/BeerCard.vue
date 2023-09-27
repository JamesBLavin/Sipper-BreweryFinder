<template>
  <div class="beer-card">
    <h2>{{ beer.beer_name }}</h2>
    <p>{{ beer.beer_description }}</p>
    <!-- Add other beer information as needed -->
  </div>
</template>

<script>
export default {
  name: "beer-card",
  props:["beer"],
};
</script>

<style scoped>
.beer-card {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
}
</style>