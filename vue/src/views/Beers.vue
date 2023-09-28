<template>
  <div class="beer-container">
      <beer-card v-for="beer in beers" :key="beer.beer_id" :beer="beer"></beer-card>
  </div>
</template>

<script>
import beerService from "../services/BeerService";
import BeerCard from '../components/BeerCard.vue';

export default {
  name: "beers",
  components: {
    BeerCard
  },
  data() {
    return {
      beers: []
    };
  },
  computed: {},
  methods: {
  },
  created() {
    beerService.getBeers().then(response => {
       console.log('Fetched beers:', response.data);
      this.beers = response.data;
    })
  }
};
</script>

<style scoped>
.beer-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
</style>