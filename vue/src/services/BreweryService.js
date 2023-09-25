import axios from 'axios';

const http = axios.create({
    baseURL: ""
});

export default {
    
    getBreweries() {
        return http.get('/allBreweries')
    }
}