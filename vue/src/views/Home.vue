<template>
  <div class="home">
    <h1 id="welcome">welcome to sipper, the coolest spot to keep up with the breweries you love and find your new fav</h1>
    <div class="search-container">
      <form class="search-bar" @submit.prevent="toggleShowBr">
        <div class="mb-3">
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="Search by city, state, or zip"
            v-model="searchQuery"
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
          >{{ buttonText }}
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a @click.prevent="updateButton('City')" class="dropdown-item" href="#">City</a>
            <a @click.prevent="updateButton('Brewery Name')" class="dropdown-item" href="#">Brewery Name</a>
            <a @click.prevent="updateButton('Zip Code')" class="dropdown-item" href="#">Zip Code</a>
          </div>
        </div>
        <button id="search-btn">search</button>
      </form>
    </div>
    <h1 v-show="$store.state.token != ''" id="login-greeting">
      thanks for drinking with us, {{ this.$store.state.user.username }}!
    </h1>
    <breweries :filter="filter" v-show="this.showBr" id="listing"/>
  </div>
</template>

<script>
import Breweries from "./Breweries.vue";
export default {
  components: { Breweries },
  name: "home",
  data() {
    return {
      showBr: false,
      buttonText: '',
      searchQuery: '',
      }
    },
  computed: {
    buttonTxt() {
      return this.buttonText;
    }
  },
  methods: {
    toggleShowBr() {
      this.showBr = !this.showBr;
      return this.showBr;
    },
    updateButton( btnText ) {
      let searchBy = '';
      this.buttonText = btnText;
      this.buttonText == 'City' ? searchBy = 'brewery_city' : 
      this.buttonText == 'Brewery Name' ? searchBy = "brewery_name" : 
      this.buttonText == 'Zip Code' ? searchBy = "brewery_zip" : searchBy = '';
      this.$store.commit('CHANGE_FILTER', searchBy);
    },
    commitTextToStore( searchQuery ) {
      this.$store.coomit('CHANGE_QUERY', searchQuery);
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
  border-radius: 25px;
  margin-top: -75%;
  margin-bottom: 50%;
  padding: 3%;
  display: flex;
  justify-content: center;
  padding: 20px 100px 20px 100px;
  align-items: flex-end;
  position: relative;
  right: 100px;
  
}

.search-container {
  margin-top: 100vh;
}

.btn-secondary {
    color: #2d7cfa;
    background-color: white;
    border-color: #2d7cfa;
}

.mb-3 {
  margin: 10vw 1vw 10vw 10vw;
  width: 50vw;
  background: #2d7cfa;
  border: #2d7cfa 20px solid;
  border-radius: 25px;
}

#dropdownMenuButton {
  border: #2d7cfa 20px solid;
  border-radius: 25px;
  margin-bottom: 25%;
}

#search-btn {
  border: #2d7cfa 20px solid;
  border-radius: 25px;
  margin-bottom: 1%;
  margin-left: 1%;
}

#listing {
  margin-top: 0%;
}

#welcome {
  position: absolute;
  left: 250px;
  background: #2d7cfa;
  padding: 10px 50px 10px 50px;
  border-radius: 25px;
  color: white;
}

#login-greeting {
  color: black;
  margin-top: -38%;
}
</style>
