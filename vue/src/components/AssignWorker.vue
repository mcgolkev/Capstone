<template>
  <div>
    <label for="maintenance_worker">Assign To: </label>
    <input
      type="text"
      name="maintenance_worker"
      id="maint_worker"
      v-model="maint_staff.staffName"
    />
    <div class="actions">
      <button
        type="submit"
        v-on:click="updateWorker(id)"
        @click="resetWorker"
      >
        Assign Staff
      </button>
    </div>
  </div>
</template>

<script>
import LandlordService from '../services/LandlordService.js'
export default {
  name: "assign-worker",
  props: {
      id: Number
  },
  data() {
    return {
      maint_staff: {
        staffName: "",
      },
    };
  },
  methods: {
      updateWorker(id){
        LandlordService.updateMaintenance(id, this.maint_staff)
      },
      resetWorker(){
      this.maint_staff = {};
      location.reload()
    },
  }
};
</script>

<style>
</style>