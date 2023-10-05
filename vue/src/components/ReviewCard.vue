<template>
  <div class="review-card">
      <h1>{{review.beer_name}}</h1>
      <img v-for="star in review.star_rating" :key="star" src="../assets/star.png" alt="" id="starz">
      <br>
      <br>
      <span class="review-comments"><strong>Review Commentary: &nbsp; {{ review.review_comments }}</strong><br></span>
      <div class="review-image">
      <p><img v-show="show" @error="dispNothing" :src="review.review_img_url" alt="no image to show" id="reviewpics"/></p>
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
  border-bottom: solid 5px #f5cd84;
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
}


</style>