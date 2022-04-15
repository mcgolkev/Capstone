<template>
  <!-- Renter:  Will want rental information (if renting) and maintenance request info, browsing properties-->
    <div>
        <div class = "rental-property-info">
        <h1>Address: {{this.$store.state.renterProperty.addressLine1}} {{this.$store.state.renterProperty.addressLine2}} 
          {{this.$store.state.renterProperty.city}} {{this.$store.state.renterProperty.state}} {{this.$store.state.renterProperty.zip}}</h1>
      <p v-if="rented.pastDue === false"> Status : Due : </p>
      <p v-else> Status: Past Due : </p>
      <p> {{this.$store.state.renterProperty.balanceDue}} </p>
        <!-- <img v-bind:src="this.$store.state.renterProperty.picture"/> -->
        </div>

        <div class="maintenance-info" v-for="maintenance in this.$store.state.maintenance" v-bind:key="maintenance.maintenanceId">
            <!-- renter just submits a message to the landlord of a problem.
            then landlord will manually assign the ticket to a drop down of the maintenance employees, which could include the maintenance types -->
          </div>

        <div class = "maintenance-request-info">
          <!-- Pull maintenance request info here
          Make a tab for maintenance request info
          Submit a maintenance request
          Notify when maintenance request is done
          display all maintenances
           -->

        <form v-on:submit.prevent>
    <div class="field">
      <label for="maintenance-type">Maintenance Type</label>
      <select name="maintenance-type" id="maintenance-type">
        <option value="plumber">Plumber</option>
        <option value="appliances">Appliances</option>
        <option value="heating-and-cooling">Heating and Cooling</option>
        </select>
      <label for="problem-description">Problem Description</label>
      <input type="text" v-model="property.number" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="saveMaintenance()">Submit Maintenance Request</button>
    </div>
  </form>
          </div>
    </div>
</template>



<script>
import RenterService from '../services/RenterService'

export default {
    name: "renter-details",
    props: ["rented"],
    methods: {
              saveMaintenance(){
            RenterService.addMaintenance(this.maintenance).then((response) => {
                if (response.status == 201){
                    this.$router.push({name: 'Home'});
                }
            })
        }
    },
    created(){
          RenterService.getRental(this.$route.params.id).then(response => {
        this.$store.commit("SET_RENTER_PROPERTY", response.data)
      }).catch(error => {
        if (error.response.status == 404){
          this.$router.push({name: 'NotFound'})
        }
      });
      
          RenterService.getMaintenance(this.$route.params.id).then(response => {
        this.$store.commit("SET_MAINTENANCE", response.data)
      }).catch(error => {
        if (error.response.status == 404){
          this.$router.push({name: 'NotFound'})
        }
      })
    },

}
</script>

<style>

</style>