<template>
  <div class="home">
    <div id="welcome-container">
    <h1 id="welcome">sipper is how you keep up with local breweries and find a new fav!</h1>
    </div>
    <div class="search-container">
        <div id="bar">
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="Search by city, state, or zip"
            v-model="searchQuery"
            @keyup="commitTextToStore(searchQuery)"
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
        <button id="search-btn" @click="displayBreweries()">search</button>
    </div>
    <!-- <h1 v-show="$store.state.token != ''" id="login-greeting">
      thanks for drinking with us, {{ this.$store.state.user.username }}!
    </h1> -->
    <!-- <breweries :filter="filter" v-show="this.showBr" id="listing"/> -->
    <brewery-card :brewery="brewery" v-for="brewery in breweries" :key="brewery.brewery_id" id="b-card"/>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService"
import BreweryCard from '../components/BreweryCard.vue';
export default {
  components: {  BreweryCard },
  name: "home",
  data() {
    return {
      showBr: false,
      buttonText: '',
      searchQuery: '',
      breweries: []
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
      this.$store.commit('CHANGE_QUERY', searchQuery);
    },
    displayBreweries() {
      if (this.$store.state.filter != '') {
              breweryService.getBreweries(this.$store.state.query, this.$store.state.filter).then(rspns => {
        this.breweries = rspns.data;
      })
      } else if (this.$store.state.filter == ''){
                alert("Please use the dropdown to select a filter.");
      }

    }
  },
  created() {
    this.$store.commit('CHANGE_FILTER', '');
    this.$store.commit('CHANGE_QUERY', '');
  }
};
</script>

<style scoped>
#welcome {
  position: relative;
  top: -425px;
  color: white; 
  border-radius: 25px;
  border: 4px solid rgba(88, 61, 45, 0.603);
  backdrop-filter: blur(45px);
  background-color: rgba(83, 61, 43, 0.384);
  padding: 5px 20px 5px 20px;
}

#welcome-container {
  display: flex;
  justify-content: center;
}

#search-btn {
  background:white;
  border: solid 5px white;
  border-radius: 10px;
}

button:hover {
  font-weight: bold;
}

.search-container {
  position: relative;
  top: -375px;
  display: flex;
}

.search-container {
  display: flex;
  justify-content: center;
  align-items: baseline;
}

#bar {
  width: 30vw;
}

#dropdownMenuButton {
  background-color: white;
  color: black;
}
</style>
