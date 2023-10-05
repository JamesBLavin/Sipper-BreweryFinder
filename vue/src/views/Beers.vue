<template>
  <div class="beer-container">
    <h1>what's good on tap?</h1>
    <div class="beer-list">
      <beer-card class="card" v-for="beer in beers" :key="beer.beer_id" :beer="beer"></beer-card>
    </div>
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
      this.beers = response.data;
    })
  }
};
</script>

<style scoped>
.beer-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}


</style>