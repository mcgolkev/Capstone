import axios from 'axios';

export default {
     get(){
      return axios.get('/apartments');
    },

    getMaintenance(){
        return axios.get('/maintenance/incomplete');
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