<template>
  <div>
    <div v-for="property in this.$store.properties" v-bind:key="property.id">
      <h1>{{property.title}}</h1>
      <p>{{property.price}}</p>
      <img v-bind:src="property.picture" v-bind:alt="property.address" />
      <p>{{property.available}}</p>
      <p>{{property.bedrooms}}</p>
      <p>{{property.bathrooms}}</p>
      <p>{{property.sqft}}</p>
      <p>{{property.shortDescription}}</p>
    </div>
      <!-- contact realtor button -->
  </div>
</template>

<script>
import propertyService from '../services/PropertyService.js';

export default {
    name: "property-details",
    methods: {
    deleteMessage(id) {
      propertyService.delete(id).then((response) => {
        if (response.status == 200){
          this.$store.commit("DELETE_PROPERTY", id);
        }
      })
    }
  },

}
</script>

<style>

</style>