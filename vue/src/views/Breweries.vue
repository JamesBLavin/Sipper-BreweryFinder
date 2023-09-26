<template>
<div>
  <brewery-card :brewery="brewery" v-for="brewery in breweries" :key="brewery"></brewery-card>
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

<style scoped>


</style>