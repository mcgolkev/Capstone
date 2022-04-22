import axios from 'axios';

export default {

    get(){
        return axios.get('notification');
    },

    update(id, notification){
        return axios.put(`/notification/${id}`, notification)
    },

    requestRental(id, notification){
        return axios.post(`/rental/application/${id}`, notification)
    }
  
  }