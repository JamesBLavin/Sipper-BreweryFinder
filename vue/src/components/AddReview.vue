<template>
  <div class="review-form">
      <h1>what did y'all think of this one?</h1>
      <form @submit.prevent="addReview">

            <label class="form-label" for="star_rating" >Rating:</label>
            <div class="range">
           <input type="range" class="form-range" min="0" max="5" id="star_rating" v-model="review.star_rating">
           <img v-for="star in starsArr" :key="star" src="../assets/star.png" alt="" id="starz">
            </div>
            

<!-- <div class="range">
<input id="myRange" 
min="1" 
max="5" 
step="10" 
type="range" 
class="form-range" />
<h4>
Current Value:
<span id="curr"></span>
</h4>
</div> -->
            <br>
            Commentary: <br> <textarea name="review_comments" id="review_comments" cols="40" rows="5" placeholder="Leave comment here" v-model="review.review_comments"></textarea>
            <br>
            <label class="form-label" for="review_image_url">Image URL:</label>
            <br> 
            <input type="text" id="review_image_url" maxlength="500" v-model="review.review_img_url" placeholder="Enter image URL" />
            <br>
            <br>
            <button>Submit</button>
      </form>
  </div>
</template>

<script>
import ReviewService from '../services/ReviewService'
export default {
    name: "add-review",
    data() {
        return {
            review: {
                beer_id: this.$route.params.id,
                user_id: this.$store.state.user.id,
                star_rating: 0
            },
        }
    },
    computed: {
      starsArr() {
        const stars = [];
        for (let i = 0; i < this.review.star_rating; i++) {
            stars.push(i);
        }
        return stars;
      }
    },
    methods: {
        addReview() {
           if(this.review.review_img_url == null){
             this.review.review_img_url = 'image.jpg'
           }
            ReviewService.addReview(this.review).then(response => {
                if(response.status == 200 || response.status == 201){
                    window.alert('Review made!');
                    // this.review={
                    //     beer_id: '',
                    //     user_id: '',
                    //     star_rating: '',
                    //     review_comments: '',
                    //     review_img_url: ''
                    // };
                    location.reload();
                }
            }).catch(error => {
                console.log(error)
            })
        }
    }
}

// var el = document.getElementById('curr');
// var r = document.getElementById('myRange');
// el.innerText = r.valueAsNumber;
// r.addEventListener('change', () => {
// el.innerText = r.valueAsNumber;
//  })

</script>

<style scoped>
.form-input {
  margin-bottom: 1rem;
}

.range {
   padding-left: 32%;
}

.form-range {
  inline-size: 300px;
  
  }
/* div[data-v-646842d9] {
    margin: 1rem;
    padding-left: 1rem;
    padding-right: 1rem;
    background: #2d7cfa;
    border-radius: 25px;
    display: flex;
    color: white;
    flex-direction: column;
    flex-wrap: nowrap;
} */

div {
  margin: 1rem;
  padding-left: 1rem;
  padding-right: 1rem;
  background: wheat;
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

.review-form {
  display: flex;
  flex-direction: column;
  color: rgb(255, 123, 0);
}
#rangeValue {
  color: rgb(255, 123, 0);
  
}

#starz {
  width: 3rem;
}

</style>