<template>
  <div>
      <h1>List of all breweries</h1>
      <brewery-card v-for="brewery in breweries" :key="brewery.breweryId"></brewery-card>
  </div>
</template>

<script>
import BreweryCard from './BreweryCard.vue';

export default {
  name: "BreweryList",
  components: { 
    BreweryCard
    }
} 
</script>

<style>
</style>

  <!-- <div class="individual" v-for="brewery in breweries" v-bind:key="brewery.breweryId">
        <h2>{{brewery.name}} (ID: {{brewery.breweryId}})</h2>
        Contact Info: {{brewery.contact}} <br />
        History: {{brewery.history}} <br />
        Operating Hours: {{brewery.hours}} <br />
        Address: {{brewery.address}}
      </div> -->