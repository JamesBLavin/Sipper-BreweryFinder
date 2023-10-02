<template>
  <div>
    <h1 id="profile-header">{{ this.$store.state.user.username }}</h1>
    <h2>my reviews</h2>
    <div id="profile-container">
      <div id="review-container">
        <review-card
          :review="review"
          v-for="review in reviews"
          :key="review.id"
          id="cards"
        ></review-card>
      </div>
      <new-brewery-form
        v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'"
        id="updater"
      />
      <beer-card v-for="beer in beers" :key="beer.id"/>
    </div>
  </div>
</template>

<script>
import NewBreweryForm from "../components/NewBreweryForm.vue";
import ReviewCard from "../components/ReviewCard.vue";
import reviewService from "../services/ReviewService";
import breweryService from "../services/BreweryService";
import beerService from "../services/BeerService";
import BeerCard from '../components/BeerCard.vue';
export default {
  components: { ReviewCard, NewBreweryForm, BeerCard },
  data() {
    return {
      reviews: [],
      brewery: {},
      beers: []
    };
  },
  created() {
    reviewService
      .getAllReviewsFromUser(this.$store.state.user.id)
      .then(rspns => {
        this.reviews = rspns.data;
      });
    breweryService
      .getBreweryByBrewer(this.$store.state.user.username)
      .then(rspns => {
        this.brewery = rspns.data;
      });
    beerService.getBeersByBreweryId(parseInt(this.brewery.brewery_id)).then(rspns => {
      this.beers = rspns.data;
    });
  },
};
</script>

<style>
#profile-header {
  font-size: 300px;
}

#review-container {
  overflow-y: scroll;
  height: 40vh;
}

#profile-container {
  display: flex;
}

h2 {
  margin-right: 90vw;
}
</style>