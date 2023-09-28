<template>
  <div class="beer-card">
    <h2>{{ beer.beer_name }}</h2>
    <div class="beer-details">
    <span class="description"><strong>{{ beer.beer_description }}</strong></span>
    <span class="beer-type"><strong>Beer Type: {{ beer.beer_type }}</strong></span>
    <span class="alcohol-info"><strong>ABV: {{ beer.abv }}%,  {{ beer.ibu }} IBU</strong></span>
    <img :src="beer.beer_img_url" alt="dust" id="beerpics"/>
    </div>
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
  border-radius: 20px;
  padding: 10px;
  margin: 10px;
  background-color: wheat;
  flex: 0 1 30%;
}

.beer-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}

h2 {
  color:rgb(145, 72, 0);
}

.description {
  color:rgb(167, 89, 0);
}
/* rgb(255, 123, 0) */
.beer-type {
  color:rgb(211, 112, 0);
}

.alcohol-info {
  color: rgb(255, 123, 0);
}

#beerpics {
  width: 95%;
  height: 15%;
  border-radius: 30px;
}

</style>