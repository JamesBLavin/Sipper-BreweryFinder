<template>
<div class="beer-details">
    <h2>{{beer.beer_name}}</h2>
  <span class="description"><strong>{{ beer.beer_description }}</strong><br></span>
  <span class="beer-type"><strong>Beer Type: {{ beer.beer_type }}</strong><br></span>
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
.beer-details{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: #2d7cfa;
    border-radius: 25px;
    padding: 40px;
    margin-left: 20%;
    margin-right: 20%;
}

.beer-image img {
    width: 40%;
    height: auto;
    border-radius: 30px;
}
</style>