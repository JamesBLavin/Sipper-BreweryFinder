<template>
  <div id="app">
    <div id="nav">
      <div id="logo-name">
     <img src="./assets/clink.png" alt="testing" id="main-logo"/>&nbsp;
     <h1>sipper</h1>
     </div>
     <div id="links">
      <router-link :to="{ name: 'home' }" tag="h2" class="nav-links">home</router-link>
      <router-link :to="{ name: 'breweries' }" tag="h2" class="nav-links">breweries</router-link>
      <router-link :to="{ name: 'beers' }" tag="h2" class="nav-links">beers</router-link>
      <router-link :to="{ name: 'profile' }" v-if="$store.state.token != ''" tag="h2" class="nav-links" id="profile">{{ this.$store.state.user.username }}</router-link>
      <router-link :to="{ name: 'add-brewery' }" tag="h2" class="nav-links" v-show="this.$store.state.user.authorities && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">+ brewery</router-link>
      <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''" tag="h2" class="nav-links">logout</router-link>
      </div>
    </div>
    <router-view id="view"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144,900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&family=Roboto+Flex:opsz,wght@8..144,400;8..144,900&display=swap" rel="stylesheet">  
  </div>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style lang="scss">
@import "~@/assets/scss/vendors/bootstrap-vue/index";

body {
  background: #f0ebdf;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: orangered;
  margin: 25px;
  font-family: 'Open Sans', sans-serif;
font-family: 'Roboto', sans-serif;
font-family: 'Roboto Flex', sans-serif;
}

#main-logo {
  width: 10%;
  margin: 10px;
  min-width: 100px;
}


#nav {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "namelogo links";
  padding-bottom: 5px;
  background: wheat;
  border-radius: 25px;
  margin-bottom: 10px;
  margin-top: 25px;
}

#logo-name {
  grid-area: namelogo;
  display: flex;
}

#links {
  grid-area: links;
  margin-top: 50px;
  display: flex;
  justify-content: space-around;
}

#nav h1 {
  font-size: 500%;
  margin: 0px;
  font-family: 'Roboto Flex', sans-serif;
}

.nav-links:hover {
  color: brown;
  cursor: pointer;
}

#profile {
  text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
  font-weight: 900;
}

</style>