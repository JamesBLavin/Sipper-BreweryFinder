<template>
  <div class="beer-card" >
      <h2 @click="goToBeerDetails">{{ beer.beer_name }}</h2>
    <div class="beer-image">
    <p><img :src="beer.beer_img_url" @error="dispDefaultImg" alt="dust" id="beerpics" /></p>
    <h3 >{{brewery.brewery_name}}</h3>
    <img v-for="star in Math.floor(beer.avg_rating)" :key="star" src="../assets/star.png" alt="" id="starz">
    <h3>({{beer.avg_rating.toFixed(2)}}/5)</h3>
    <h3 v-show="beer.avg_rating == 0">No ratings yet</h3>
    <button @click="deleteBeer" class="btn btn-danger" v-show="this.$route.path == '/profile' " id="trash-btn">
    <svg id="trash" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z"/></svg></button>
    <button @click="toggleShowUpdate" class="btn btn-light" v-show="this.$route.path == '/profile' " id="edit-btn">
    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M471.6 21.7c-21.9-21.9-57.3-21.9-79.2 0L362.3 51.7l97.9 97.9 30.1-30.1c21.9-21.9 21.9-57.3 0-79.2L471.6 21.7zm-299.2 220c-6.1 6.1-10.8 13.6-13.5 21.9l-29.6 88.8c-2.9 8.6-.6 18.1 5.8 24.6s15.9 8.7 24.6 5.8l88.8-29.6c8.2-2.7 15.7-7.4 21.9-13.5L437.7 172.3 339.7 74.3 172.4 241.7zM96 64C43 64 0 107 0 160V416c0 53 43 96 96 96H352c53 0 96-43 96-96V320c0-17.7-14.3-32-32-32s-32 14.3-32 32v96c0 17.7-14.3 32-32 32H96c-17.7 0-32-14.3-32-32V160c0-17.7 14.3-32 32-32h96c17.7 0 32-14.3 32-32s-14.3-32-32-32H96z"/></svg></button>
    <update-beer id="update-card" v-show="showUpdate" :beer-id="beer.beer_id"/>
    </div>
  </div>
</template>

<script>
import beerService from '../services/BeerService';
import breweryService from '../services/BreweryService';
import UpdateBeer from './UpdateBeer.vue';
export default {
  components: { UpdateBeer},
  name: "beer-card",
  props:["beer"],
  data() {
    return {
      brewery: {},
      showUpdate: false
    }
  },
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
    },
    goToBeerDetails() {
      this.$router.push({ name: 'beer-details', params: { id: this.beer.beer_id } });
    },
    toggleShowUpdate() {
      this.showUpdate = !this.showUpdate;
    }
  },
  created() {
            breweryService.getBreweryByID(this.beer.brewery_id).then(resp => {
          this.brewery = resp.data;
        });
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
  background-color: #4a3415;
  /* cursor: pointer; */
}

/* .beer-image {
  width: 50%;
} */

h2 {
  /* rgb(145, 72, 0) */
  color: rgba(43, 30, 12, 0.815);
  /* rgba(43, 30, 12, 0.815) */
  cursor: pointer;
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

#trash-btn {
  fill:white;
  background-color: brown;
  border: solid wheat;
  margin-right: 5px;
}

#edit-btn {
  fill: gray;
  border: solid wheat;
}

h2, h3 {
  color: white;
}

#update-card {
  margin-top: 10px;
}
</style>