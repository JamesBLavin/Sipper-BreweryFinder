<template>
  <div class="beer-card">
      <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: beer.beer_id } }">
      <h2>{{ beer.beer_name }}</h2>
    </router-link>
    <div class="beer-image">
    <p><img :src="beer.beer_img_url" @error="dispDefaultImg" alt="dust" id="beerpics" /></p>
    <img v-for="star in beer.avg_rating" :key="star" src="../assets/star.png" alt="" id="starz">
    <h3 v-show="beer.avg_rating == 0">No ratings yet</h3>
    <button @click="deleteBeer" class="btn btn-danger" v-show="this.$route.path == '/profile' " id="trash-btn">
    <svg id="trash" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z"/></svg></button>
    </div>
  </div>
</template>

<script>
import beerService from '../services/BeerService';
export default {
  name: "beer-card",
  props:["beer"],
  methods: {
    dispDefaultImg(event) {
      event.target.src = require('@/assets/IMG_0879.jpg');
    },
    deleteBeer() {
      if (confirm("Do you really want to delete this beer?")) {
      beerService.deleteBeer(this.beer.beer_id).then(rspns => {
        if(rspns.status == 204) {
            window.alert('Beer removed!');
        }
        });
    }
      location.reload();
    }
  }
};
</script>

<style scoped>
.beer-card {
  border-radius: 20px;
  padding: 10px;
  margin: 10px;
  flex: 1 1 18.3%;
  justify-content: center;
  align-items: center;
  background-color: wheat;
}

/* .beer-image {
  width: 50%;
} */

h2 {
  /* rgb(145, 72, 0) */
  color: rgba(43, 30, 12, 0.815);
  /* rgba(43, 30, 12, 0.815) */
}

h2:hover{
  color:rgb(214, 153, 62);
}

.detailsLink {
  text-decoration: none;
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

#beerpics {
  width: 15vw;
  height: auto;
  border-radius: 30px;
}

#starz {
  width: 2rem;
}

svg {
  fill:#ffffff
}

#trash-btn {
  margin-left: 2rem;
}
</style>