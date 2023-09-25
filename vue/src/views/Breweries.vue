<template>
<div>
  <!-- <brewery-card v-for="brewery in breweries" :key="brewery.breweryId"></brewery-card> -->
  
  <div v-for="brewery in breweries" :key="brewery.breweryId">{{ brewery.brewery_name }}</div>
</div>
</template>

<script>
import breweryService from "../services/BreweryService";
// import BreweryCard from "../components/BreweryCard.vue";
export default {
  name: "breweries",
  // components: {
  //   BreweryCard
  // },
  props: ['brewery'],
  data() {
    return {
      breweries: []
    }
  },
  computed: {},
  methods: {},
  created() {
    breweryService.getBreweries().then(rspns => {
      this.breweries = rspns.data;
    })
  }
}
</script>

<style>

</style>