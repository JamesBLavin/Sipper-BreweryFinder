<template>
<div>
  <br>
  <h1>find your new fav spot</h1>
  <br>
  <brewery-card :brewery="brewery" v-for="brewery in allBreweries" :key="brewery.brewery_id"></brewery-card>
</div>
</template>

<script>
import breweryService from "../services/BreweryService";
import BreweryCard from "../components/BreweryCard.vue";
export default {
  name: "breweries",
  components: {
    BreweryCard
  },
  data() {
    return {
      allBreweries: []
    }
  },
  methods: {},
  created() {
    breweryService.listAllBreweries().then(rspns => {
      this.allBreweries = rspns.data;
    });
  }
}
</script>

<style scoped>


</style>

  //   filteredBreweries() {
  //     let sortedBreweries = this.breweries;
  //     if (this.$store.state.filter == 'brewery_name') {
  //     sortedBreweries = sortedBreweries.filter((brwry) => {
  //       return brwry.brewery_name.toLowerCase().includes(this.filter.brewery_name)
  //     });
  //     } else if (this.$store.state.filter == 'brewery_city') {
  //     sortedBreweries = sortedBreweries.filter((brwry) => {
  //       return brwry.brewery_city.toLowerCase().includes(this.filter.brewery_city)
  //     });
  //     } else if (this.$store.state.filter == 'brewery_zip'){
  //     sortedBreweries = sortedBreweries.filter((brwry) => {
  //       return brwry.brewery_zip == this.filter.brewery_zip
  //     });
  //     } else{sortedBreweries = this.breweries}
  //   return sortedBreweries;
  // }