import axios from 'axios';

export default {
     get(){
      return axios.get('/properties/available');
    },

    getMaintenance(){
        return axios.get('/maintenance/incomplete');
      },

    getRentInfo(id){
        return axios.get(`/rent/${id}`)
    },

    getRented(){
        return axios.get('/properties/rented')
    },

    create(){
        return axios.post('/properties/');
    },

    updateProperty(id){
        return axios.put(`/properties/${id}`);
    },

    deleteProperty(id){
        return axios.delete(`/properties/${id}`);
    },

    updateMaintenance(id){
        return axios.put(`/maintenance/${id}`);
    },
}