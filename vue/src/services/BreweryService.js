import axios from 'axios';

export default {
    
    getBreweries() {
        return axios.get('/allBreweries');
    },

    addBrewery(brewery) {
        return axios.post('/addBrewery', brewery)
    }
}