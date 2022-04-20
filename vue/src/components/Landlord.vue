<template>
  <div>
    <div
      class="rental-property-info"
      v-for="property in this.$store.state.renterProperty"
      v-bind:key="property.propertyId"
    >
      <input
        type="checkbox"
        id="availability-status"
        name="availability-status"
        :value="property.availableForRent"
        v-model="property.availableForRent"
        @change="(updateProperty(property.availableForRent, property.propertyId))"
      />
      
      <h1>
        Address: {{ property.addressLine1 }}
        {{ property.addressLine2 }}
        {{ property.city }}
        {{ property.state }}
        {{ property.zip }}
      </h1>
      <router-link
        :to="{ name: 'add-property', params: { id: property.propertyId } }"
        ><button type="button">Edit Property</button></router-link
      >
      <label for="rentee">Rented to: </label>
      <input type="text" name="rentee" id="rentee" />
    </div>

    <div>
      <create-property />
    </div>

<!-- /properties/rented -->
    <div
      class="rented-properties"
      v-for="property in this.$store.state.rentedProperty"
      v-bind:key="property.propertyId"
    >
      <h1>
        Address: {{ property.addressLine1 }}
        {{ property.addressLine2 }}
        {{ property.city }}
        {{ property.state }}
        {{ property.zip }}
      </h1>

      <account-info :id="property.propertyId" />
         
    </div>

    <div class="maintenance">
      <div
        v-for="maint in this.$store.state.maintenance"
        v-bind:key="maint.maintenanceId"
      >
        <p>Date: {{ maint.dateSubmitted }}</p>
        <p>Description: {{ maint.description }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import LandlordService from "../services/LandlordService";
import CreateProperty from "./CreateProperty.vue";
import AccountInfo from './AccountInfo.vue'
export default {
  components: { CreateProperty, AccountInfo },
  data(){
    return {
      rentInfo: {}
    }
  },
  methods: {
    getRentInfo(id) {
      LandlordService.getRentInfo(id).then((response) => {
        this.rentInfo = response.data;
        return this.rentInfo;
      });
    },
     updateProperty(available, id){
      const property = {availableForRent: available};
        LandlordService.update(id, property)
      }
  },
  created() {
      LandlordService.get()
        .then((response) => {
          this.$store.commit("SET_RENTER_PROPERTY", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });

        LandlordService.getRented()
        .then((response) => {
          this.$store.commit("SET_RENTED_PROPERTY", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });

      LandlordService.getMaintenance()
        .then((response) => {
          this.$store.commit("SET_MAINTENANCE", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });
    },
};
</script>

<style>
.show-hide {
  display: none;
}
</style>

<!--
-Add a way to register with role
-check puts
-check posts
-Logged in renter should be able to send landlord a request to rent

bind the edit property to the id and then send in as prop of property with the values


-->

