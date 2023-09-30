<template>
  <div class="review-card">
    <div v-for="review in beerReviews" :key="review.review_id" class="review-info">
      <h1>{{review.beer_name}}</h1>
      <img v-for="star in review.star_rating" :key="star" src="../assets/star.png" alt="" id="starz">
      <span class="review-comments"><strong>Review Commentary: {{ review.review_comments }}</strong><br></span>

    </div>
  </div>
</template>

<script>
import reviewService from '../services/ReviewService';

export default {
  name: "review-card",
  props: ["review"],
  data() {
    return {
      beerReviews: []
    };
  },
  created() {
    reviewService.getAllReviews().then(response => {
      this.beerReviews = response.data;
    });
  }
};
</script>

<style scoped>
.review-card {
  border-radius: 20px;
  padding: 10px;
  margin: 10px;
  background-color: wheat;
  flex: 1 1 18.3%;
  justify-content: center;
  align-items: center;
}

#starz {
  width: 3rem;
}
</style>