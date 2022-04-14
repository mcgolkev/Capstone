<template>
  <div>
    <div>
        <!-- <img v-bind:src="property.picture" v-bind:alt="property.address1" /> -->
    <h1>Address: {{this.$store.state.activeProperty.addressLine1}} {{this.$store.state.activeProperty.addressLine2}} {{this.$store.state.activeProperty.city}} {{this.$store.state.activeProperty.state}} {{this.$store.state.activeProperty.zip}}</h1>
      <p> Date Available: {{this.$store.state.activeProperty.dateAvailable}}, ${{this.$store.state.activeProperty.price}}</p>
      <p>Bed: {{this.$store.state.activeProperty.numBedrooms}} Bath: {{this.$store.state.activeProperty.numBathrooms}} {{this.$store.state.activeProperty.squareFeet}}sqft</p>
      <p>Description: {{this.$store.state.activeProperty.longDescription}}</p>
        <img v-bind:src="this.$store.state.activeProperty.picture"/>
    </div>
      <!-- contact realtor button -->
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService'
export default {
    name: "property-details",
    methods: {},
    created(){
      PropertyService.getProperty(this.$route.params.id).then(response => {
        this.$store.commit("SET_ACTIVE_PROPERTY", response.data)
      }).catch(error => {
        if (error.response.status == 404){
          this.$router.push({name: 'NotFound'})
        }
      })
    }

}
</script>

<style>

</style>