<template>
  <div class="home">
    <!-- <div class="renter-view" v-if="this.$store.state.user.role === 'user'">
      <renter />
    </div> -->
   <!-- <renter />
    <maintenance /> -->
    <landlord />
  </div>
</template>

<script>
import Landlord from '../components/Landlord.vue';
//import Maintenance from '../components/Maintenance.vue';
//import Renter from '../components/Renter.vue'

export default {
  name: "home",
  components: {Landlord} //Renter, Maintenance
}
</script>
