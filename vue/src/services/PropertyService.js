import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000/"
  });

export default {

    get(){
        return http.get('properties');
    },

    getProperty(id){
        return http.get(`properties/${id}`);
    },

    addProperty(property){
      return http.post('properties', property);
    },

    deleteProperty(id){
      return http.delete(`properties/${id}`)
    }
  
  }
  