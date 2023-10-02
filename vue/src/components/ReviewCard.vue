<template>
  <div class="review-card">
      <h1>{{review.beer_name}}</h1>
      <img v-for="star in review.star_rating" :key="star" src="../assets/star.png" alt="" id="starz">
      <span class="review-comments"><strong>Review Commentary: {{ review.review_comments }}</strong><br></span>
  </div>

  
</template>

<script>

export default {
  name: "review-card",
  props: ["review"],
  data() {
    return {
    };
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