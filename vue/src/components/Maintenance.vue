<template>
  <div>
      <div v-for="maint in this.$store.state.maintenance" v-bind:key="maint.maintenanceId">
          <router-link :to="{name: 'maintenance', params: {id: maint.maintenanceId}}"><p>Date: {{maint.dateSubmitted}}</p>
          <p>From: {{maint.ownershipId}}</p></router-link>
    </div>
    </div>
</template>

<script>
import MaintenanceService from "../services/MaintenanceService";

export default {
    name: 'maintenance',
  created() {
    MaintenanceService.get().then((response) => {
        this.$store.commit("SET_MAINTENANCE", response.data);
      }).catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
  
  },
};
</script>

<style>
</style>