<template>
  <div>
    <h1 id="profile-header">{{this.$store.state.user.username}}</h1>
    <review-card :review="review" v-for="review in reviews" :key="review.id"></review-card>
  </div>
</template>

<script>
import ReviewCard from '../components/ReviewCard.vue'
import reviewService from '../services/ReviewService';
export default {
  components: { ReviewCard },
  data() {
    return {
        reviews: []
    }
  },
    created() {
    reviewService.getAllReviews().then(rspns => {
      this.reviews = rspns.data;
    });
  }

}
</script>

<style>
#profile-header {
  font-size: 300px;
}


</style>