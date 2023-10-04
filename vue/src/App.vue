<template>
  <div id="app">
    <div :id="navHome ? 'nav-home' : 'nav-nothome'" class="all-nav">
      <div id="logo-name">
     <img src="./assets/clink.png" alt="testing" id="main-logo"/>&nbsp;
     <h1 id="title">sipper</h1>
     </div>
     <div id="links">
      <router-link :to="{ name: 'home' }" tag="h2" class="nav-links">home</router-link>
      <router-link :to="{ name: 'beers' }" tag="h2" class="nav-links">beers</router-link>
      <router-link :to="{ name: 'breweries' }" tag="h2" class="nav-links">breweries</router-link>
      <router-link :to="{ name: 'profile' }" v-if="$store.state.token != ''" tag="h2" class="nav-links" id="profile">{{ this.$store.state.user.username }}</router-link>
      <router-link :to="{ name: 'add-brewery' }" tag="h2" class="nav-links" v-show="this.$store.state.user.authorities && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">+ brewery</router-link>
      <router-link :to="{ name: 'login' }" v-if="loggedIn" tag="h2" class="nav-links">login</router-link>
      <router-link :to="{ name: 'logout' }" v-if="!loggedIn" tag="h2" class="nav-links">logout</router-link>
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
  name: 'app',
  computed: {
    loggedIn() {
      return this.$store.state.token == '';
    },
    navHome() {
      return this.$route.path == '/';
    }
  }
}
</script>

<style lang="scss">
@import "~@/assets/scss/vendors/bootstrap-vue/index";
#title {
  font-size: 650%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: sandybrown;
  margin: 25px;
  font-family: 'Open Sans', sans-serif;
font-family: 'Roboto', sans-serif;
font-family: 'Roboto Flex', sans-serif;
}
#main-logo {
  width: 10%;
  margin: 10px;
  min-width: 140px;
}
.all-nav {
  color: white;
}
#nav-home {
  display: grid;
  grid-template-columns: 2fr 3fr;
  grid-template-areas: "namelogo links";
  padding-bottom: 30vw;
  border-radius: 25px;
  margin-bottom: 10px;
  margin-top: 25px;
  background-image: url('./assets/52475430061_6b2df9ebae_b.jpg');
  background-size: 100vw;
  max-width: 100vw;
  background-repeat: no-repeat;
}

#nav-home .nav-links {
color: white;
}

#logo-name {
  grid-area: namelogo;
  display: flex;
  border-radius: 10px;
  padding: 10px;
  margin: 15px;
}
#links {
  grid-area: links;
  margin-top: 125px;
  display: flex;
  justify-content: space-around;
  margin-right: 10%;
  margin-bottom: 7px;
  padding-top: 10px;
  // background: #7f513ae1;
  border-radius: 20px;
}
#nav h1 {
  font-size: 500%;
  margin: 0px;
  font-family: 'Roboto Flex', sans-serif;
}
.nav-links:hover {
  color:sienna;
  cursor: pointer;
}
#profile {
  text-decoration: underline;
}
h1, h2, h3, h4, h5, h6 {
  font-weight: 900;
}
.nav-links {
  border-radius: 10px;
  padding: 5px 20px 5px 20px;
  height: 30%;
}

body {
  background-color: #fbfcef;
}

#nav-nothome{
  color: sandybrown;
  padding: 5px;

}

#view {
  z-index: 3;
}
</style>