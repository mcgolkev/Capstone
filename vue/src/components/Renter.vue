<template>
  <!-- Renter:  Will want rental information (if renting) and maintenance request info-->
    <div>
        <div>
        <h1>Address: {{this.$store.state.rentedProperty.addressLine1}} {{this.$store.state.rentalProperty.addressLine2}} {{this.$store.state.rentalProperty.city}} {{this.$store.state.rentalProperty.state}} {{this.$store.state.rentalProperty.zip}}</h1>
      <p> Price: ${{this.$store.state.rentedProperty.price}}</p>
        <img v-bind:src="this.$store.state.rentedProperty.picture"/>
        </div>
    </div>
</template>



<script>
import RenterService from '../services/RentalService'

export default {
    name: "renter-details",
    methods: {},
    created(){}
}
</script>

<style>

</style>