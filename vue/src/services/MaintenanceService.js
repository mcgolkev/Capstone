import axios from 'axios';

export default {
     get(){
      return axios.get('/maintenance/incomplete');
    },

    getbyId(id){
        return axios.get(`/maintenance/${id}`)
    },

    update(id){
        return axios.put(`/maintenance/${id}`)
    }
}

