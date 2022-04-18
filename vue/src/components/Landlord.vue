<template>
  <div>
      <div
      class="rental-property-info"
      v-for="property in this.$store.state.renterProperty"
      v-bind:key="property.propertyId"
    >
    <input type="checkbox" id="availability-status" name="availability-status" v-model="property.availableForRent" >
      <h1>
        Address: {{ property.addressLine1 }}
        {{ property.addressLine2 }}
        {{ property.city }}
        {{ property.state }}
        {{ property.zip }}
      </h1>
      <router-link :to="{name: 'add-property', params: {id: property.propertyId}}"><button type="button">Edit Property</button></router-link>
      <label for="rentee">Rented to: </label>
      <input type="text" name="rentee" id="rentee" />
    </div>
    
    <div class="show-hide">
    <create-property />
    </div>

     <div class="maintenance">
         <div v-for="maint in this.$store.state.maintenance" v-bind:key="maint.maintenanceId">
             <p>Date: {{maint.dateSubmitted}}</p>
             <p>Description: {{maint.description}}</p>
            </div>
    </div>
    
      </div>
</template>

<script>
import LandlordService from '../services/LandlordService'
import CreateProperty from './CreateProperty.vue';
export default {
  components: { CreateProperty },
     created() {
    LandlordService.get().then((response) => {
        this.$store.commit("SET_RENTER_PROPERTY", response.data);
      }).catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });

      LandlordService.getMaintenance().then((response) => {
        this.$store.commit("SET_MAINTENANCE", response.data);
      }).catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });

     }

}
</script>

<style>
    .show-hide{
        display: none;
    }
</style>