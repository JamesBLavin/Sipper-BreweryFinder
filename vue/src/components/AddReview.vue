<template>
  <div>
      <h1>Leave a review, and tell us what you think! Please fill out the form:</h1>
      <form>
          <label class="form-label" for="star_rating">Rating:</label>
            <div class="range">
            <input type="range" class="form-range" min="0" max="5" id="star_rating" />
            </div>
            <br>
            Commentary: <textarea name="review_comments" id="review_comments" cols="40" rows="5" placeholder="Leave comment here"></textarea>
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

/* .range{
    background: white;
} */
</style>