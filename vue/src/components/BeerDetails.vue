<template>
<div class="beer-details">
  <span class="description"><strong>{{ beer.beer_description }}</strong></span>
  <span class="beer-type"><strong>Beer Type: {{ beer.beer_type }}</strong></span>
  <span class="alcohol-info"><strong>ABV: {{ beer.abv }}%,  {{ beer.ibu }} IBU</strong></span>
    <div class="beer-image">
        <img :src="beer.beer_img_url" alt="dust" id="beerpics"/>
    </div>
</div>

</template>

<script>
import beerService from '../services/BeerService';

export default {
    name: "beer-details",
    data(){
        return {
            beer: {}
        };
    },
    created() {
        beerService.getBeerByID(this.$route.params.id).then(response => {
             this.beer = response.data;
             
        })
        .catch(error => {
            console.error("Error fetching beer details:", error);
        });
    }
};
</script>

<style>

</style>