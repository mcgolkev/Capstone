import axios from 'axios';

export default {

     getRental(userID){
      return axios.get(`home/${userID}`);
    }

}