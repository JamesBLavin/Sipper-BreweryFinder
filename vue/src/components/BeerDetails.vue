<template>
<div class="beer-details">
    <h2>{{beer.beer_name}}</h2>
  <span class="description"><strong>{{ beer.beer_description }}</strong><br></span>
  <span class="beer-type"><strong>Beer Type: {{ beer.beer_type }}</strong><br></span>
  <span class="alcohol-info"><strong>ABV: {{ beer.abv }}%,  {{ beer.ibu }} IBU</strong><br><br></span>
  <h3>{{brewery.brewery_name}}</h3>
    <div class="beer-image">
        <img :src="beer.beer_img_url" @error="dispDefaultImg" alt="dust" id="beerpics"/><br><br>
        <h2>Average Rating:</h2>&nbsp;&nbsp;&nbsp;&nbsp;<img v-for="star in Math.floor(beer.avg_rating)" :key="star" src="../assets/star.png" alt="" id="starz" v-show="beer.avg_rating > 0">
        <h3 v-show="beer.avg_rating > 0">({{beer.avg_rating.toFixed(2)}}/5)</h3>
        <h3 v-show="beer.avg_rating == 0">No ratings yet</h3>
        <hr>
    </div>
    <div>
    <add-review v-show="this.$store.state.token != ''"></add-review>
    
    </div>
    <div class="rev-card">
            <h2 v-show="this.$store.state.token == ''" @click="loginAndReroute" id="login-link">wanna give your two cents? login or make an account</h2>
      <hr>
      <h2>reviews from users</h2>  
    <review-card :review="review" v-for="review in revs" :key="review.review_id" id="rvew"/>
    </div>
</div>

</template>

<script>
import beerService from '../services/BeerService';
import ReviewService from '../services/ReviewService';
import AddReview from './AddReview.vue';
import ReviewCard from './ReviewCard.vue';
import breweryService from '../services/BreweryService';
export default {
    name: "beer-details",
    components:
    {ReviewCard, AddReview},
    data(){
        return {
            beer: {},
            reviews: [],
            revs: [],
            brewery: {}
        };
    },
  created() {
    beerService.getBeerByID(this.$route.params.id)
      .then(response => {
        this.beer = response.data;
        breweryService.getBreweryByID(this.beer.brewery_id).then(resp => {
          this.brewery = resp.data;
        });
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
  },
    methods: {
    dispDefaultImg(event) {
      event.target.src = require('@/assets/IMG_0879.jpg');
    },
    loginAndReroute() {
       this.$store.commit("SET_POST_LOGIN_PAGE", this.$route.path)
      this.$router.push('/login');
    }
  }
};
</script>

<style scoped>
.beer-details{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: #4a3415;
    border-radius: 25px;
    padding: 40px;
    margin-left: 20%;
    margin-right: 20%;
    border: 2px solid #d6c29d;
}

.beer-image img {
    width: 40%;
    height: auto;
    border-radius: 30px;
}

hr {
  border: 2px solid white;
}

h2 {
  color:rgba(43, 30, 12, 0.815);
}

h2, h2 + #starz {
  display:inline-flex;
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

#starz {
  width: 3rem;
  margin-bottom: 1rem;
}

h2, h3, span strong {
  color: white;
}

#rvew {
  border-bottom: solid 15px white;
}

#login:hover {
  cursor: pointer;
  text-decoration: underline;
}

#login-link {
  cursor: pointer;
}
</style>