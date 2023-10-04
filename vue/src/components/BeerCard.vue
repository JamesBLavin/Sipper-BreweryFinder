<template>
  <div class="beer-card">
      <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: beer.beer_id } }">
      <h2>{{ beer.beer_name }}</h2>
    </router-link>
    <div class="beer-image">
    <p><img :src="beer.beer_img_url" @error="dispDefaultImg" alt="dust" id="beerpics" /></p>
    <img v-for="star in beer.avg_rating" :key="star" src="../assets/star.png" alt="" id="starz">
    <h3 v-show="beer.avg_rating == 0">No ratings yet</h3>
    <button @click="deleteBeer" v-show="this.$route.path == '/profile'">testing</button>
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
            window.alert('Brewery removed!');
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
  background-color: wheat;
  flex: 1 1 18.3%;
  justify-content: center;
  align-items: center;
}

/* .beer-image {
  width: 50%;
} */

h2 {
  color:rgb(145, 72, 0);
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
</style>