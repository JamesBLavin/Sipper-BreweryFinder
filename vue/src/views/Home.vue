<template>
  <div class="home">
    <div class="search-container">
      <form class="search-bar" @submit.prevent="toggleShowBr">
        <div class="mb-3">
          <input
            type="email"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="name@example.com"
          />
        </div>
        <div>
          <button
            class="btn btn-secondary dropdown-toggle"
            type="button"
            id="dropdownMenuButton"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Dropdown button
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </div>
        <button>Save</button>
      </form>
    </div>
    <h1 v-show="$store.state.token != ''">
      thanks for drinking with us, {{ this.$store.state.user.username }}!
    </h1>
    <breweries v-show="this.showBr"/>
  </div>
</template>

<script>
import Breweries from "./Breweries.vue";
export default {
  components: { Breweries },
  name: "home",
  data() {
    return {
      showBr: false
    }
  },
  methods: {
    toggleShowBr() {
      this.showBr = !this.showBr;
      return this.showBr;
    }
  }
};
</script>

<style scoped>
h1 {
  color: black;
}

.search-bar {
  /* margin-top: -25%;
  margin-bottom: 25%;
  display: flex;
  justify-content: center;
  padding-top: 1%;
  padding-left: -20%;
  padding-right: -20%;
  margin-left: 33%;
  justify-content: center; */
  border: black solid 3px;
  border-radius: 10px;
  margin-top: -60%;
  margin-bottom: 25%;
  padding: 10px;
  background: white;
  display: flex;
  justify-content: center;
}

.search-container {
  display: flex;
  margin-left: 40%;
}


</style>
