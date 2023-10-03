import axios from 'axios';

export default {

    getAllReviews() {
        return axios.get(`/reviews`);
    },
    getReviewsByBeerId(beer_id) {
        beer_id = parseInt(beer_id);
        return axios.get(`/reviews/${beer_id}`);
    },
    getAllReviewsFromUser(user_id) {
        return axios.get(`/reviewsByUser?user_id=${user_id}`);
    },
    getReview(review_id) {
        return axios.get(`/reviews/${review_id}`)
    },
    addReview(newReview) {
        return axios.post('/addReview', newReview)
    },
    updateReview(updatedReview, review_id){
        return axios.put(`/reviews/${review_id}`, updatedReview)
    },
    deleteReview(review_id){
        return axios.delete(`breweries/${review_id}`)
    }
}


 