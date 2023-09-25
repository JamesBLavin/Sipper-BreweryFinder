import axios from 'axios';

export default {
    
    getBreweries() {
        return axios.get('/allBreweries');
    },

    
}