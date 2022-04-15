import axios from 'axios';

export default {

     getRental(){
      return axios.get('home/');
    },

    getRentInfo(){
      return axios.get('rent');
    },

    getMaintenance(){
      return axios.get('maintenance');
    },

    addMaintenance(userID, maintenance){
      return axios.post(`home/${userID}/maintenance`, maintenance);
    }

    // userID may just be pulled from the backend

}