<template>
  <div class="brewery-card" @click="toggleShow">
    
    <h2 :class="{ 'centered': show, 'left-aligned': !show }">{{ brewery.brewery_name }} | {{ brewery.brewery_city }} , {{ brewery.brewery_state }}</h2>
    <h3 class="full-details" v-show="show">
      <div class="left-side">
        <img :src="brewery.brewery_img_url" alt="dust" id="previewpics"/>
      </div>
      <div class="right-side">
        <p>{{ brewery.contact_info }}</p>
        <p>{{ brewery.brewery_history }}</p>
        <p>{{ brewery.operating_hours }}</p>
        
        <p>
          <a :href="getGoogleMapsLink(brewery.brewery_name + ' ' + brewery.brewery_address)" target="_blank">{{ brewery.brewery_address }}, {{ brewery.brewery_city }}, {{ brewery.brewery_state }} {{ brewery.brewery_zip }}</a></p>
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
  color: lightgray;
  cursor: pointer;
}

.full-details a {
  color: blue;
  text-decoration: none;
}

.full-details a:hover {
  color: cyan;
}

#previewpics {
  width: 300px;
  border-radius: 30px;
  margin-bottom: 30px;
}

.brewery-card {
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  justify-content: space-between;
  background-color: #4287f5;
  color: white;
}


.full-details {
  display: flex;
  flex-direction: row;
  align-items: center;
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

h2 {
  padding: 7px;
  margin-left: 20px;
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


</style>