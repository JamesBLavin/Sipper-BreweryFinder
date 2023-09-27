<template>
<div>
  <form @submit.prevent="addBrewery">
      <h1>add an establishment</h1>
      <div class="form-input-group">
      <input type="text" placeholder="brewery name" required class="inputboxes" v-model="brewery.brewery_name">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="brewer username" required class="inputboxes" v-model="brewery.brewer">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="phone number or email" class="inputboxes" v-model="brewery.contact_info">
      </div>
      <div class="form-input-group">
      <textarea class="inputboxes" id="history" rows="8" placeholder="enter a blurb briefly detailing the history of the brewery" v-model="brewery.brewery_history"></textarea>
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="operating hours" class="inputboxes" v-model="brewery.operating_hours">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="enter an image url from the brewery website or social media" class="inputboxes" v-model="brewery.brewery_img_url">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="street address" class="inputboxes" v-model="brewery.brewery_address">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="city" class="inputboxes" v-model="brewery.brewery_city">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="state" class="inputboxes" v-model="brewery.brewery_state">
      </div>
      <div class="form-input-group">
      <input type="text" placeholder="zip code" class="inputboxes" v-model="brewery.brewery_zip">
      </div>
      <button>finalize addition</button>
  </form>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService';
export default {
    data() {
        return {
            brewery: {}
        }
    }, methods: {
        addBrewery() {
            breweryService.addBrewery(this.brewery).then(rspns => {
                if(rspns.status == 201 || rspns.status == 200) {
                    window.alert('Brewery added!');
                    this.brewery= {};
                }
            }).catch(err => {
                console.log(err);
            })
        }
    }
}
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}

div {
  padding-left: 2rem;
  background: wheat;
  border-radius: 25px;
  display: flex;
}

button:hover {
  font-weight: bold;
}

.inputboxes {
  border: solid 5px white;
  border-radius: 10px;
  width: 50vw;
  max-width: 100vw;
}

button {
  background:tan;
  border: solid 5px tan;
  border-radius: 10px;
  margin-bottom: 10px;
}

</style>