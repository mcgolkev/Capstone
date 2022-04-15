<template>
  <div class="home">
    <h1>Home</h1>
    <div class="renter-view" v-if="this.$store.state.user.role === 'user'">
      <renter />
    </div>
  </div>
</template>

<script>
import Renter from '../components/Renter.vue'

export default {
  name: "home",
  components: {Renter}
};
</script>
