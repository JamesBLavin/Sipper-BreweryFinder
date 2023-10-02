<template>
  <div>
<review-card :review="review" v-for="review in reviews" :key="review.review_id"> </review-card>

  </div>
</template>

<script>
import ReviewService from '../services/ReviewService'
import ReviewCard from '../components/ReviewCard.vue'
export default {
  components: { ReviewCard }, 
  data(){
     return{ 
         reviews:[]
      }
      
  },
  created(){
    ReviewService.getAllReviews().then(resp =>
    {this.reviews = resp.data;});
  }
  


}
</script>

<style>

</style>