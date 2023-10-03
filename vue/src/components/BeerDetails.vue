<template>
<div class="beer-details">
    <h2>{{beer.beer_name}}</h2>
  <span class="description"><strong>{{ beer.beer_description }}</strong><br></span>
  <span class="beer-type"><strong>Beer Type: {{ beer.beer_type }}</strong><br></span>
  <span class="alcohol-info"><strong>ABV: {{ beer.abv }}%,  {{ beer.ibu }} IBU</strong></span>
    <div class="beer-image">
        <img :src="beer.beer_img_url" alt="dust" id="beerpics"/><br><br>
        <img v-for="star in beer.avg_rating" :key="star" src="../assets/star.png" alt="" id="starz" v-show="beer.avg_rating > 0">
        <h3 v-show="beer.avg_rating == 0">No ratings yet</h3>
    </div>
    

    <review-card :review="review" v-for="review in revs" :key="review.review_id" />
</div>

</template>

<script>
import beerService from '../services/BeerService';
import ReviewService from '../services/ReviewService';
import ReviewCard from './ReviewCard.vue';
export default {
    name: "beer-details",
    components:
    {ReviewCard},
    data(){
        return {
            beer: {},
            reviews: [],
            revs: []
        };
    },
  created() {
    beerService.getBeerByID(this.$route.params.id)
      .then(response => {
        this.beer = response.data;
      })
      .catch(error => {
        console.error("Error fetching beer details:", error);
      });

    
    ReviewService.getReviewsByBeerId(this.$route.params.id)
      .then(resp => {
        this.revs = resp.data;
      })
      .catch(error => {
        console.error("Error fetching reviews:", error);
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

#starz {
  width: 3rem;
}
</style>