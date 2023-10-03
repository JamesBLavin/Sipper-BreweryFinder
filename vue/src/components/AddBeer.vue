<template>
  <div>
      <h1>To add a new beer, please submit the following fields:</h1>
        <div class="form-input">
        <form @submit.prevent="addBeer">
        <input type="text" placeholder="beer name" required class="input-box" v-model="beer.beer_name"/>
        <br><br>
        <input type="text" placeholder="description" required class="input-box" v-model="beer.beer_description"/>
        <br><br>
        <input type="number" step="any" placeholder="abv" required class="input-box" v-model="beer.abv" />
        <br><br>
        <input type="number" placeholder="ibu" required class="input-box" v-model="beer.ibu" />
        <br><br>
        <input type="text" placeholder="enter an image url from the brewery website or social media" required class="input-box" v-model="beer.beer_image_url" />
        <br><br>
        <input type="text" placeholder="beer type" required class="input-box" v-model="beer.beer_type" />
        <br><br>
        <button>Submit</button>
        </form>
        </div>
</div>
</template>

<script>
import BeerService from '../services/BeerService'
import BreweryService from '../services/BreweryService'


export default {
  data() {
    return {
      beer: {},
      // brewery: {}
    }
  },
  methods: {
    addBeer() {
      BeerService.addBeer(this.beer).then(response => {
        if(response.status == 200 || response.status == 201){
          window.alert('Brewery added!');
          this.beer={
            brewery_id: '',
            beer_name: '',
            beer_description: '',
            abv: '',
            ibu: '',
            beer_img_url: '',
            beer_type: ''
          };
        }
      }).catch(error => {
        console.log(error)
      })
    }
  },
  created() {
    BreweryService.getBreweryByBrewer(this.$store.state.user.username).then(rspns => {
            this.brewery = rspns.data;
    });
  }
}
</script>

<style scoped>
.form-input {
  margin-bottom: 1rem;
}

div {
  margin: 1rem;
  padding-left: 1rem;
  padding-right: 1rem;
  background: #2d7cfa;
  border-radius: 25px;
  display: flex;
  color: white;
}

button:hover {
  font-weight: bold;
}

.input-box {
  border: solid 5px white;
  border-radius: 10px;
  width: 50vw;
  max-width: 100vw;
}

button {
  background: white;
  border: solid 5px white;
  border-radius: 10px;
  margin-bottom: 10px;
}
</style>