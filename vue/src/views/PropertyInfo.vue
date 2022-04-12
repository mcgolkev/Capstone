<template>
    <div>
  <property-details v-bind:property-id="parseInt($route.params.id)" />
  </div>
</template>

<script>
import propertyDetails from '../components/propertyDetails.vue'
export default {
  components: { propertyDetails },

}
</script>

<style>

</style>