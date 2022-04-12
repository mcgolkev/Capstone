<template>
  <div>
    <div>
        <h1>Address: {{this.$store.state.activeProperty.addressLine1}}</h1>
        <p>{{this.$store.state.activeProperty.city}}</p>
        <p>{{this.$store.state.activeProperty.state}}</p>
        <p>{{this.$store.state.activeProperty.zip}}</p>
      <p>{{this.$store.state.activeProperty.price}}</p>
      <!-- <img v-bind:src="property.picture" v-bind:alt="property.address" /> -->
      <p>{{this.$store.state.activeProperty.dateAvailable}}</p>
      <p>{{this.$store.state.activeProperty.numBedrooms}}</p>
      <p>{{this.$store.state.activeProperty.numBathrooms}}</p>
      <p>{{this.$store.state.activeProperty.squareFeet}}</p>
      <p>{{this.$store.state.activeProperty.shortDescription}}</p>
    </div>
      <!-- contact realtor button -->
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService'
export default {
    name: "property-details",
    props:  {
    propertyId: Number
  },
    methods: {},
    created(){
      PropertyService.get(this.propertyId).then(response => {
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