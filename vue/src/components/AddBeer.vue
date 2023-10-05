<template>
  <div class="beer-form">
    <br>
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
        <input type="text" placeholder="enter an image url from the brewery website or social media" maxlength="500" required class="input-box" v-model="beer.beer_img_url" />
        <br><br>
        <input type="text" placeholder="beer type" required class="input-box" v-model="beer.beer_type" />
        <br><br>
        <button>Submit</button>
        </form>
        </div>
</div>
</template>

<script>
import BeerService from '../services/BeerService';

export default {
  props: {
    breweryId: {
      type: Number,
    }
  },
  data() {
    return {
      beer: {
        brewery_id: this.breweryId,
        beer_name: '',
        beer_description: '',
        abv: '',
        ibu: '',
        beer_img_url: '',
        beer_type: ''
      }
    };
  },
  methods: {
     addBeer() {
      this.beer.brewery_id = this.breweryId;

      
      BeerService.addBeer(this.beer)
        .then(response => {
          if (response.status === 200 || response.status === 201) {
            window.alert('Beer added!');
            this.resetBeer();
            location.reload();
          }
        })
        .catch(error => {
          console.error('Error adding beer:', error);
        });
    },
    resetBeer() {
      this.beer = {
        brewery_id: null,
        beer_name: '',
        beer_description: '',
        abv: '',
        ibu: '',
        beer_img_url: '',
        beer_type: ''
      };
    }
  }
};

</script>

<style scoped>
.form-input {
  margin-bottom: 1rem;
}

.beer-form {
  display: flex;
  flex-direction: column;
  background: wheat;
  /* border: 2px solid #d6c29d;
  border-radius: 25px; */
  border: 5px solid sandybrown;
  /* border-radius: 25% 25% 5% 25%; */
  color: white;
  /* margin: 1rem; */
}

button:hover {
  font-weight: bold;
}

.input-box {
  border: solid 5px white;
  border-radius: 10px;
  width: 75%;
  height: auto;
  max-width: 100vw;
}

button {
  background: white;
  border: solid 5px white;
  border-radius: 10px;
  margin-bottom: 10px;
}
</style>