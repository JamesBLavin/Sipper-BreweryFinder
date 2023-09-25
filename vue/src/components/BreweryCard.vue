<template>
  <div class="brewery-card">
    <h2 :brewery="brewery">{{brewery.brewery_name}}</h2>
  </div>
</template>

<script>
export default {
    name: "BreweryCard"
    }

</script>

<style>
.brewery-card:hover {
  color: peru;
}
</style>