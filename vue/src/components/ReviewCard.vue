<template>
  <div class="review-card">
    <div class="review-info">
      <span class="star-rating"><strong>Star Rating Out Of 5 Stars: {{ review.stra_rating }}</strong><br></span>
      <span class="review-comments"><strong>Review Commentary: {{ review.review_comments }}</strong><br></span>  
   
      <h1>Test</h1> 

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
    reviewService.getReview(this.review.beer_id).then(response => {
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
</style>