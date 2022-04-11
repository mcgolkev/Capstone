<template>
  <div>
    <div v-for="property in this.$store.properties" v-bind:key="property.id">
    <h1>{{property.title}}</h1>
      <p>{{property.price}}</p>
      <img />
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
export default {

}
</script>

<style>

</style>