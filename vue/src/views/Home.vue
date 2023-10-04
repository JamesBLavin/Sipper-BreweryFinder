<template>
  <div class="home">
    <h1 id="welcome">sipper is how you keep up with local breweries and find a new fav!</h1>
    <div class="search-container">
      <form class="search-bar" @submit.prevent="toggleShowBr">
        <div class="mb-3">
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
      </form>
    </div>
    <h1 v-show="$store.state.token != ''" id="login-greeting">
      thanks for drinking with us, {{ this.$store.state.user.username }}!
    </h1>
    <!-- <breweries :filter="filter" v-show="this.showBr" id="listing"/> -->
    <brewery-card :brewery="brewery" v-for="brewery in breweries" :key="brewery.brewery_id"/>
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
      breweryService.getBreweries(this.$store.state.query, this.$store.state.filter).then(rspns => {
        this.breweries = rspns.data;
      })
    }
  }
};
</script>

<style scoped>
h1 {
  color: sandybrown;
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
  margin-top: -85%;
  margin-bottom: 50%;
  padding: 3%;
  display: flex;
  justify-content: center;
  padding: 10px 10px 10px 10px;
  align-items: flex-end;
  position: relative;
  right: 10px;
  /* border: 4px solid rgba(255, 255, 255, 0.815);
  padding: none;
  margin-left: 25px;
  backdrop-filter: blur(45px);
  background-color: rgba(51, 51, 51, 0.384); */
}

.search-container {
  margin-top: 121vh;
}



.btn-secondary {
    color:   #7f513ae1;
    background-color: white;
    border-color:   #7f513ae1;
}

.mb-3 {
  margin: 10vw 1vw 10vw 10vw;
  width: 50vw;
  /* background:    #7f513ae1; */
  /* border:    #7f513ae1 20px solid; */
  /* border-radius: 25px; */
}

#dropdownMenuButton {
  /* border:    #7f513ae1 20px solid; */
  /* border-radius: 5px; */
  margin-bottom: 44%;
}

#search-btn {
  /* border:    #7f513ae1 20px solid; */
  /* border-radius: 25px; */
  margin-bottom: 20px;
  margin-left: 1rem;
}

#listing {
  margin-top: 0%;
}

#welcome {
  position: absolute;
  left: 180px;
  right: 180px;
  /* backdrop-filter: blur(15px); */
  margin-top: 35px;
  padding: 10px 50px 10px 50px;
  border-radius: 25px;
  /* border: solid 2px lightgrey; */
  color: white;
  z-index: 1;
    border: 4px solid rgba(88, 61, 45, 0.603);
  padding: none;
  margin-left: 25px;
  backdrop-filter: blur(45px);
  background-color: rgba(83, 61, 43, 0.384);
}

#login-greeting {
  color: #7f513ae1;
  margin-top: -49%;
}


</style>
