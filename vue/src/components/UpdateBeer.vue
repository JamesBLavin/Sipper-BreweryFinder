<template>
  <div class="beer-form">
    <br>
      <h1>update your beer: {{ brew.beer_name }}</h1>
        <div class="form-input">
        <form @submit.prevent="updateBeer">
        <input type="text" placeholder="beer name" required class="input-box" v-model="brew.beer_name"/>
        <br><br>
        <input type="text" placeholder="description" required class="input-box" v-model="brew.beer_description"/>
        <br><br>
        <input type="number" step="any" placeholder="abv" required class="input-box" v-model="brew.abv" />
        <br><br>
        <input type="number" placeholder="ibu" required class="input-box" v-model="brew.ibu" />
        <br><br>
        <input type="text" placeholder="enter an image url from the brewery website or social media" maxlength="500" required class="input-box" v-model="brew.beer_img_url" />
        <br><br>
        <input type="text" placeholder="beer type" required class="input-box" v-model="brew.beer_type" />
        <br><br>
        <button >finalize updates</button>
        </form>
        </div>
</div>
</template>

<script>
import beerService from '../services/BeerService';

export default {
    props: {
        beerId: {
            type: Number
        }
    },
  data() {
    return {
      brew: {}
    };
  },
  methods: {
      updateBeer() {
          beerService.updateBeer(this.brew).then(rspns => {
          if (rspns.status === 200 || rspns.status === 201) {
            window.alert('Beer updated!');
          }
        })
        .catch(error => {
          console.error('Error adding beer:', error);
        });
      }
},
created() {
    beerService.getBeerByID(this.beerId).then(rspns => {
        this.brew = rspns.data;
    })
}
}

</script>

<style scoped>
.form-input {
  margin-bottom: 1rem;
}

.beer-form {
  display: flex;
  flex-direction: column;
  background: wheat;
  /* border: 2px solid #d6c29d;*/
  border-radius: 25px;
  border: 5px solid wheat;
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