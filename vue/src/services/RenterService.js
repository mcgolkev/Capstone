import axios from 'axios';

export default {

     getRental(userID){
      return axios.get(`home/${userID}`);
    },

    getMaintenance(userID){
      return axios.get(`home/${userID}`);
    },

    addMaintenance(userID, maintenance){
      return axios.post(`home/${userID}/maintenance`, maintenance);
    }

    // userID may just be pulled from the backend

}