<template>
  <div>
    <div
      class="rental-property-info"
      v-for="property in this.$store.state.renterProperty"
      v-bind:key="property.propertyId"
    >
      
      <h1>
        Address: {{ property.addressLine1 }}
        {{ property.addressLine2 }}
        {{ property.city }}
        {{ property.state }}
        {{ property.zip }}
      </h1>
      <router-link
        :to="{ name: 'add-property', params: { id: property.propertyId } }"
        ><button type="button">Edit Property</button>
      </router-link>
      <button type="button" v-on:click="deleteProperty(property.propertyId)" @click="reloadPage">Delete Property</button>
      <label for="rentee">Rented to: </label>
      <input type="text" name="rentee" id="rentee" v-model="user.userId" />
      <div class="actions">
          <button type="submit" v-on:click="updateProperty(property.propertyId)" @click="resetRentee">
            Submit Renter Info
          </button>
        </div>
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

        <label for="maintenance_worker">Assign To: </label>
      <input type="text" name="maintenance_worker" id="maint_worker" v-model="maint_staff.staffName" />
      <div class="actions">
          <button type="submit" v-on:click="updateWorker(maint.maintId)" @click="resetWorker">
            Assign Staff
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LandlordService from "../services/LandlordService";
import CreateProperty from "./CreateProperty.vue";
import AccountInfo from './AccountInfo.vue'
import PropertyService from '../services/PropertyService'

export default {
  components: { CreateProperty, AccountInfo },
  data(){
    return {
      rentInfo: {},
      user: {
        userId: ""
      },
      maint_staff: {
        staffName: ""
      }
    }
  },
  methods: {
    getRentInfo(id) {
      LandlordService.getRentInfo(id).then((response) => {
        this.rentInfo = response.data;
        return this.rentInfo;
      });
    },
     updateProperty(id){
        LandlordService.updateRenter(id, this.user)
      },
      updateWorker(id){
        LandlordService.updateMaintenance(id, this.maint_staff)
      },
      deleteProperty(id){
          PropertyService.deleteProperty(id).then((response) => {
                if (response.status == 201){
                    this.$router.push({name: 'Home'});
                }
            })
    }, 
      resetRentee(){
      this.user = {};
      location.reload()
    },
      resetWorker(){
      this.maint_staff = {};
      location.reload()
    },
    reloadPage(){
      location.reload()
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

