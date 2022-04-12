<template>
  <div class="property-list">
      <div v-for="property in this.$store.state.properties" v-bind:key="property.propertyId">
        <h1><router-link :to="{name: 'property-info', params: {id: property.propertyId}}">Address: {{property.addressLine1}}</router-link></h1>
        <p>{{property.city}}</p>
        <p>{{property.state}}</p>
        <p>{{property.zip}}</p>
      <p>{{property.price}}</p>
      <!-- <img v-bind:src="property.picture" v-bind:alt="property.address" /> -->
      <p>{{property.dateAvailable}}</p>
      <p>{{property.numBedrooms}}</p>
      <p>{{property.numBathrooms}}</p>
      <p>{{property.squareFeet}}</p>
      <p>{{property.shortDescription}}</p>
      </div>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService.js'
export default {
    name: "property-list",
    methods: {
        getProperties(){
            PropertyService.get().then(response => {
                this.$store.commit("SET_PROPERTY", response.data)
            })
        },
        deleteProperty(id) {
            PropertyService.delete(id).then((response) => {
             if (response.status == 200){
            this.$store.commit("DELETE_PROPERTY", id);
        }
      })
    }
    },
    created(){
        this.getProperties();
    }

};
</script>

<style>

</style>