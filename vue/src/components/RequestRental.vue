<template>
   <div id="this-not-bunches" class="tile is-parent is-8">
    <div id="this-is-bunches" class="tile is-vertical box">
        <p><b>Request Rental Form</b>
            <!-- User ID: {{this.$store.state.user.id}}  -->     </p>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="message">To rent this property, please enter the property id and your user id -</label>
      <input type="text" v-model="notification.message" /><br/>
    </div>
    <div class="actions">
      <button type="submit" v-on:click="request()" @click="resetNotification">Request Property</button>
    </div>
  </form>
  </div>
  </div>
</template>

<script>
import NotificationService from '../services/NotificationService'
export default {
    name: "request-rental",
    props: {
        id: Number
    },
    data(){
        return {
            notification: {
                message: ""
            }
        }
    },
    methods: {
        request(){
            NotificationService.requestRental(this.id, this.notification);
        },
        resetNotification(){
            this.notification = {};
            location.reload;
        }
    }
}
</script>

<style scoped>


</style>