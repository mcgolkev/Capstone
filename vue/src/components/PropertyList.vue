<template>
  <div class="property-list column">
  <div class="tile is-ancestor">

    <div class="tile is-parent">

    <div class="property-information" v-for="property in this.$store.state.properties" v-bind:key="property.propertyId">

    <div class="tile is-child">


      <img v-bind:src="property.picture" />
      </div>
       <div class="tile is-vertical" id="propertyInfo">
        <h1><router-link :to="{name: 'property-info', params: {id: property.propertyId}}">Address: {{property.addressLine1}} {{property.city}} {{property.state}} {{property.zip}}</router-link></h1>
        <p> Date Available: {{property.dateAvailable}}, ${{property.price}}</p>
          <p>Bed: {{property.numBedrooms}} Bath: {{property.numBathrooms}} {{property.squareFeet}}sqft</p>
          <p>Description: {{property.shortDescription}}</p>
          </div>
         </div>
       </div>
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
