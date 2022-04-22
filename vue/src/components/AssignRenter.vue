<template>
  <div>
    <label for="rentee"
      ><br /><br /><b>Assign property:</b><br />
      Enter renter's user ID:
    </label>
    <input type="text" name="rentee" id="rentee" v-model="user.id" />
    <div class="actions">
      <button
        type="submit"
        v-on:click="updateProperty(id)"
        @click="resetRentee"
      >
        Assign Renter to Property
      </button>
    </div>
  </div>
</template>

<script>
import LandlordService from '../services/LandlordService.js';
export default {
  name: "assign-renter",
  props: {
      id: Number
  },
  data(){
    return {
      user: {
        id: ""
      }
    }
  },
  methods: {
       updateProperty(id){
        LandlordService.updateRenter(id, this.user)
      },
       resetRentee(){
      this.user = {};
      location.reload()
    },
  }
};
</script>

<style>
</style>