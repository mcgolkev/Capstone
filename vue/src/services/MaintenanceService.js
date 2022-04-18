import axios from 'axios';

export default {
     get(){
      return axios.get('/maintenance/incomplete');
    },

    getById(id){
        return axios.get(`/maintenance/${id}`)
    },

    update(id){
        return axios.put(`/maintenance/${id}`)
    }
}

