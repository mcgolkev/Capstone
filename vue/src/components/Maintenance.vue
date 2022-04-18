<template>
  <div>
      <div v-for="maintenance in this.$store.state.maintenance" v-bind:key="maintenance.maintenanceId">
          <p>Date: {{maintenance.dateSubmitted}}</p>
          <p>From: {{maintenance.ownershipId}}</p>
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