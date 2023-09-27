import axios from 'axios';

export default {

    getBreweries() {
        return axios.get('/allBreweries');
    },
    getBreweryByID(id) {
        return axios.get(`/breweries/${id}`)
    },
    addBrewery(brewery) {
        return axios.post('/addBrewery', brewery)
    },
    updateBrewery(brewery){
        return axios.put(`/breweries`, brewery)
    },
    deleteBrewery(id){
        return axios.delete(`breweries/${id}`)
    },
}