<template>
  <div>
      <div v-for="maint in this.$store.state.activeMaintenance" v-bind:key="maint.maintenanceId">
      <p>Description: {{maint.description}}</p>
      </div>
  </div>
</template>

<script>
import MaintenanceService from '../services/MaintenanceService';
export default {
    name: 'maintenance-info',
    created(){
          
    MaintenanceService.getById(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_MAINTENANCE", response.data);
      }).catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
    }
}
</script>

<style>


</style>