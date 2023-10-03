<template>
<div>
  <form @submit.prevent="handleSubmission">
      <h1 >{{this.$route.path == '/profile' ? "update your brewery " + brewery.brewery_name : 
        this.$route.path == '/breweries/addBrewery' ? "add an establishment" : ""}}</h1>
      <div class="form-input-group">
      <input type="text" placeholder="brewery name" required class="inputboxes" v-model="brewery.brewery_name">
      </div>
      <div class="form-input-group">
      <select v-show="this.$route.path == '/breweries/addBrewery'" placeholder="brewer username" required class="inputboxes" v-model="brewery.brewer">
        <option v-for="user in users" :key="user.user_id" value="user">{{ user.username }}</option>
      </select>
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
      <button>{{this.$route.path == '/profile' ? "finalize updates" : this.$route.path == '/breweries/addBrewery' ? "finalize addition" : ""}}</button>
      
  </form>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService';
import authService from '../services/AuthService';
export default {
    data() {
        return {
            brewery: {},
            users: []
        }
    }, methods: {
        handleSubmission() {
          if (this.$route.path == '/breweries/addBrewery') {
            this.addBrewery()
          } else if(this.$route.path == '/profile') {
             this.updateBrewery()
          }
        },
        addBrewery() {
            breweryService.addBrewery(this.brewery).then(rspns => {
                if(rspns.status == 201 || rspns.status == 200) {
                    window.alert('Brewery added!');
                    this.brewery= {
                        brewery_name: '',
                        brewery_brewer: '',
                        contact_info: '',
                        brewery_history: '',
                        operating_hours: '',
                        brewery_img_url: '',
                        brewery_address: '',
                        brewery_city: '',
                        brewery_state: '',
                        brewery_zip: ''
                    };
                }
            }).catch(err => {
                console.log(err);
            });
        
        },
        updateBrewery() {
          breweryService.updateBrewery(this.brewery).then(response => {
            if(response.status == 200) {
              window.alert('Brewery has been updated!');
              this.brewery= {
                brewery_name: '',
                
                contact_info: '',
                brewery_history: '',
                operating_hours: '',
                brewery_img_url: '',
                brewery_address: '',
                brewery_city: '',
                brewery_state: '',
                brewery_zip: ''
          };
        }
    }).catch(error => {
      console.log(error);
    });
    }
  },

    
    created() {
          authService.getUsers().then(rspns => {
            this.users = rspns.data;
          });
          if (this.$route.path == '/profile') {
          breweryService.getBreweryByBrewer(this.$store.state.user.username).then(rspns => {
            this.brewery = rspns.data;
          });
    }
}
    };
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}

div {
  margin: 1rem;
  padding-left: 2rem;
  padding-right: 2rem;
  background: #2d7cfa;
  border-radius: 25px;
  display: flex;
  color: white;
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
  background: white;
  border: solid 5px white;
  border-radius: 10px;
  margin-bottom: 10px;
}

</style>