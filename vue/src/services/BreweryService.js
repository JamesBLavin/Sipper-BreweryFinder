import axios from 'axios';

export default {

    listAllBreweries(){
        return axios.get(`/breweries`)
    },

    getBreweries(query, searchBy) {
        return axios.get(`/allBreweries?query=${query}&searchType=${searchBy}`);
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
    getBreweryByBrewer(username) {
        return axios.get(`/breweries/update/${username}`)
    }
}