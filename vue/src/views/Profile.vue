<template>
  <div>
    <h1 id="profile-header">{{ this.$store.state.user.username }}'s brew hub</h1>
    <div id="profile-container">
     <p id="title-left">my personal reviews</p>
     <p v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" id="title-right">{{brewery.brewery_name}}'s beers</p>
      <div class="stuff-container" id="left-one"> 
        
        <review-card :review="review" v-for="review in reviews" :key="review.id" id="cards"></review-card>
      </div>
       <!-- <h1>{{this.brewery.brewery_name}} beers</h1> -->
       <p v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" id="title-last">product management</p>
      <div v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" class="stuff-container" id="right-one">
        
      <beer-card :beer="beer" v-for="beer in beers" :key="beer.id"  />
      </div>
      <div v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" id="left-two">
      <new-brewery-form />
      </div>
      <div v-show="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" id="right-two">
      <add-beer  :brewery-id="brewery.brewery_id" />
      </div>
    </div>
  </div>
</template>

<script>
import NewBreweryForm from "../components/NewBreweryForm.vue";
import ReviewCard from "../components/ReviewCard.vue";
import reviewService from "../services/ReviewService";
import breweryService from "../services/BreweryService";
import beerService from "../services/BeerService";
import BeerCard from "../components/BeerCard.vue";
import AddBeer from '../components/AddBeer.vue';
export default {
  components: { ReviewCard, NewBreweryForm, AddBeer, BeerCard },
  data()
    {
    return {
      reviews: [],
      brewery: {},
      beers: [],
    };
  },
  created() {
    reviewService
      .getAllReviewsFromUser(this.$store.state.user.id)
      .then((rspns) => {
        this.reviews = rspns.data;
      });
    breweryService
      .getBreweryByBrewer(this.$store.state.user.username)
      .then((rspns) => {
        this.brewery = rspns.data;
        beerService
          .getBeersByBreweryId(parseInt(this.brewery.brewery_id))
          .then((rspns) => {
            this.beers = rspns.data;
          });
      });
  },
};
</script>

<style scoped>

#profile-header {
  font-size: 150px;
}

.stuff-container {
  /* border-top: 5px solid sandybrown;
  border-bottom: 30px solid sandybrown;
  border-left: 5px solid sandybrown;
  border-right: 30px solid sandybrown;
  border-radius: 25% 25% 5% 25%; */
  border: 5px solid sandybrown;
  overflow-y: auto;
  height: 75vh;
  /* width: 50%; */
}

.stuff-container::webkit-scrollbar-track{
  height: 10vh;
}

#profile-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "title-left title-left"
  "one one"
  "title-right title-right"
  "two two"
  "title-last title-last"
  "three four";
  gap: 2vw;
  justify-items: center;
}



#title-left{
  text-decoration:underline;
  font-size:250%;
  font-weight:bold;
  grid-area: title-left;
}

#title-right{
  text-decoration:underline;
  font-size:250%;
  font-weight:bold;
  grid-area: title-right;
}

#title-last{
  text-decoration: underline;
  font-size:250%;
  font-weight:bold;
  grid-area: title-last;
}

#left-one{
grid-area: one;
width: 80vw;
}

#right-one{
  grid-area: two;
  width: 80vw;
}

#left-two{
  grid-area: three;
  width: 45vw;
}

#right-two{
  grid-area: four;
  width: 45vw;
}

h2 {
  margin-right: 90vw;
}
</style>