<template>
  <div class="brewery-card" @click="toggleShow" :style="{ 'background-image': 'url(' + brewery.brewery_img_url+ ')'}">
    
    <h2 :class="{ 'centered': show, 'left-aligned': !show }">{{ brewery.brewery_name }} | {{ brewery.brewery_city }} , {{ brewery.brewery_state }}</h2>
    <h3 class="full-details" v-show="show">
      <div class="left-side">
        <img :src="brewery.brewery_img_url" alt="dust" id="previewpics" />
      </div>
      <div class="right-side">
        <p>{{ brewery.contact_info }}</p>
        <p>{{ brewery.brewery_history }}</p>
        <p>{{ brewery.operating_hours }}</p>
        
        <p>
          <svg id="map-icon" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M215.7 499.2C267 435 384 279.4 384 192C384 86 298 0 192 0S0 86 0 192c0 87.4 117 243 168.3 307.2c12.3 15.3 35.1 15.3 47.4 0zM192 128a64 64 0 1 1 0 128 64 64 0 1 1 0-128z"/></svg>&nbsp;&nbsp;<a :href="getGoogleMapsLink(brewery.brewery_name + ' ' + brewery.brewery_address)" target="_blank">{{ brewery.brewery_address }}, {{ brewery.brewery_city }}, {{ brewery.brewery_state }} {{ brewery.brewery_zip }}</a></p>
          <div id="beerz">
        <h2>Flagship Beers</h2>
       <div v-if="breweryBeers.length >= 4">
         <ul>
           <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: breweryBeers[0].beer_id } }">
             <li>{{breweryBeers[0].beer_name}}</li>
           </router-link> 
           <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: breweryBeers[1].beer_id } }">
             <li>{{breweryBeers[1].beer_name}}</li>
            </router-link> 
           <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: breweryBeers[2].beer_id } }">
             <li>{{breweryBeers[2].beer_name}}</li>
            </router-link> 
           <router-link class="detailsLink" :to="{ name: 'beer-details', params: { id: breweryBeers[3].beer_id } }">
             <li>{{breweryBeers[3].beer_name}}</li>
            </router-link> 
         </ul>
        </div>
         <p v-else>No beers to display</p>
         </div>
      </div>
    </h3>
  </div>
</template>

<script>
import beerService from '../services/BeerService';

export default {
    name: "brewery-card",
    props: ["brewery"],
    data() {
      return {
        show: false,
        breweryBeers: []
      }
    },
    methods: {
   toggleShow() {
      this.show = !this.show;
    },
      getGoogleMapsLink(address) {
        return `https://www.google.com/maps?q=${(address)}`;
      }
    },
    created() {
      beerService.getBeersByBreweryId(this.brewery.brewery_id).then(response => {
             this.breweryBeers = response.data;
    });
  }
}
</script>

<style scoped>
.brewery-card:hover {
  background-color: wheat;
  cursor: pointer;
}

.full-details a {
  color: rgb(255, 253, 231);
  text-decoration: none;
}

.full-details a:hover {
  text-decoration: underline;
}

#previewpics {
  /* width: 300px; */
  width: 20vw;
  border-radius: 30px;
  margin-bottom: 30px;
}

.brewery-card {
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  justify-content: space-between;
 background-size: cover;
  border: 1px solid #d6c29d;
  color: white;
  border-radius: 15px;

}


.full-details {
  display: flex;
  flex-direction: row;
  align-items: center;
  backdrop-filter: blur(10px);
  margin: 0;
  background-color: rgba(66, 66, 66, 0.397);
}

.left-side {
  flex: 1;
}

.right-side {
  flex: 2;
  text-align: left;
}

ul {
  columns: 2;
}

.brewery-card > h2 {
  padding: 7px;
  margin-left: 20px;
  color: white;
  backdrop-filter: blur(10px);
  margin: 0;
  padding: 15px;
  background-color: rgba(66, 66, 66, 0.397);
  border-radius: 15px;
}

.centered h2 {
  text-align: center;
}

.left-aligned {
  text-align: left;
}

.brewery-card {
  margin-bottom: 10px;
}

#beerz {
  padding: 7px;
  margin-left: 20px;
  color: white;
  backdrop-filter: blur(10px);
  margin: 0px 15px 15px 0px;
  padding: 15px;
  background-color: rgba(66, 66, 66, 0.774);
  border-radius: 15px;
  border: 2px solid rgb(68, 68, 68);
}

#map-icon {
  fill: #fffde7;
}
</style>