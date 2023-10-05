<template>
  <div :class="this.$route.name == 'beer-details' ? 'review-card' : 'review-card-profile'">
      <h1>{{review.beer_name}}</h1>
      <img v-for="star in review.star_rating" :key="star" src="../assets/star.png" alt="" id="starz">
      <br>
      <br>
      <span class="review-comments"><strong>Review Commentary: &nbsp; {{ review.review_comments }}</strong><br></span>
      <div class="review-image">
      <p><img v-show="show" @error="dispNothing" :src="review.review_img_url" alt="no image to show" id="reviewpics"/></p>
<!-- alt="no image to show" -->
    
      </div>
  </div>
</template>

<script>

export default {
  name: "review-card",
  props: ["review"],
  data() {
    return {
      show: true
    };
  },
  methods: {
    dispNothing() {
      this.show = false;
    }
  }
};
</script>

<style scoped>
.review-card {
  padding-right: 20px;
  padding-left: 20px;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: 10px;
  background-color: wheat;
  justify-content: center;
  align-items: center;
  border-radius: 25px;
}

.review-card-profile {
  padding-right: 20px;
  padding-left: 20px;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: 10px;
  background-color: #4a3415;
  justify-content: center;
  align-items: center;
  border-radius: 25px;
  color: white;
}

#starz {
  width: 3rem;
}

.review-image{
  width: 100%;
}


#reviewpics{
  height: auto;
  width: 50%;
  margin: 80px;
  border-radius: 25px;
}

h1 {
  color: white;
}

</style>