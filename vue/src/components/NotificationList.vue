<template>
  <div class="notification-list">
    <div
      v-for="notification in this.$store.state.notifications"
      v-bind:key="notification.notificationId"
    >
    <input type="checkbox" id="notification-status" name="notification-status" v-model="notification.read" >
    <p>{{notification.message}}</p>
    </div>
  </div>
</template>

<script>
import NotificationService from "../services/NotificationService.js";

export default {
  name: "notification-list",
  methods: {
    getNotifications() {
      NotificationService.get().then((response) => {
        this.$store.commit("SET_NOTIFICATIONS", response.data);
      });
    },
  },
  created() {
    this.getNotifications();
  },
};
</script>

<style>
</style>