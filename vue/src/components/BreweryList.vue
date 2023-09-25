<template>
  <div>
      <h1>List of all breweries</h1>
      
      <div class="individual" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
        <h2>{{brewery.name}} (ID: {{brewery.breweryId}})</h2>
        Contact Info: {{brewery.contact}} <br />
        History: {{brewery.history}} <br />
        Operating Hours: {{brewery.hours}} <br />
        Address: {{brewery.address}}
      </div>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService.js';

export default {
    name: "BreweryList",
    data() {
        return{
            breweries: []
        }
    },
    // We want to load breweries as soon as someone visits the page
    created(){
        breweryService.getBreweries()
            .then(response => this.breweries = response.data)
    }
}
</script>

<style>
</style>