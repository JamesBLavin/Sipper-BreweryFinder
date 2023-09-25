<template>
  <div class="home">
    <h1>thanks for drinking with us, {{ this.$store.state.user.username }}!</h1>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
