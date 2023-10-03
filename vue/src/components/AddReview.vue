<template>
  <div>
      <h1>Leave a review, and tell us what you think! Please fill out the form:</h1>
      <form>

            <label class="form-label" for="star_rating">Rating:</label>
            <div class="range">
           <input type="range" class="form-range" min="1" max="5" id="star_rating" />
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
            Commentary: <textarea name="review_comments" id="review_comments" cols="40" rows="5" placeholder="Leave comment here"></textarea>
            <br>
            <label class="form-label" for="review_image_url">Image URL:</label>
            <br> 
            <input type="url" id="review_image_url" v-model="review.review_img_url" placeholder="Enter image URL" />
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
            review: {},
        }
    },
    methods: {
        addReview() {
            ReviewService.addReview(this.review).then(response => {
                if(response.status == 200 || response.status == 201){
                    window.alert('Review made!');
                    this.review={
                        beer_id: '',
                        user_id: '',
                        star_rating: '',
                        review_comments: '',
                        review_img_url: ''
                    };
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
  background-color: gold;
  min-block-size: 10%;

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

/* .range{
    background: white;
} */
</style>