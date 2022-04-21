<template>
  <!-- Renter:  Will want rental information (if renting) and maintenance request info, browsing properties-->
  <div>
    <div
      class="rental-property-info"
      v-for="property in this.$store.state.renterProperty"
      v-bind:key="property.propertyId"
    >
      <h1>
        Address: {{ property.addressLine1 }}
        {{ property.addressLine2 }}
        {{ property.city }}
        {{ property.state }}
        {{ property.zip }}
      </h1>
    </div>
    <rent-info />

    <div class="payment-form">
      <form v-on:submit.prevent>
        <div class="field">
          <p>Payment Form:</p>
          <label for="date">Date:</label>
          <input type="date" name="date" id="date" v-model="payment.date" />
          <label for="amount">Amount:</label>
          <input
            type="text"
            name="amount"
            id="amount"
            v-model="payment.amount"
          />
        </div>
        <label for="memo">Memo:</label>
          <input
            type="text"
            name="memo"
            id="memo"
            v-model="payment.memo"
          />
        <div class="actions">
          <button type="submit" v-on:click="savePayment()" @click="resetPayment">
            Submit Payment
          </button>
        </div>
      </form>
    </div>

    <div class="notifications">
      <p>Notification List:</p>
      <notification-list />
    </div>

    <div class="maintenance-form">
      <form v-on:submit.prevent>
        <div class="field">
          <!-- <label for="maintenance-type">Maintenance Type</label>
          <select name="maintenance-type" id="maintenance-type" v-model="maintenance.type">
            <option value="plumber">Plumber</option>
            <option value="appliances">Appliances</option>
            <option value="heating-and-cooling">Heating and Cooling</option>
          </select> -->
          <p>Maintenance Request:</p>
          <label for="problem-description">Problem Description</label>
          <input type="text" v-model="maintenance.description" />
        </div>
        <div class="actions">
          <button type="submit" v-on:click="saveMaintenance()">
            Submit Maintenance Request
          </button>
        </div>
      </form>
    </div>
  </div>
</template>



<script>
import RenterService from "../services/RenterService";
import NotificationList from "../components/NotificationList.vue";
import RentInfo from "./RentInfo.vue";

export default {
  name: "renter-details",
  props: ["rented"],
  components: { NotificationList, RentInfo },
  data() {
    return {
      maintenance: {
        type: "",
        description: "",
      },
      payment: {
        amount: "",
        memo: "",
        date: "",
      },
    };
  },
  methods: {
    saveMaintenance() {
      RenterService.addMaintenance(this.maintenance).then((response) => {
        if (response.status == 201) {
          this.$router.push({ name: "Home" });
        }
      });
    },
    savePayment() {
      const payment = {amount: this.payment.amount, memo: this.payment.memo, date: this.payment.date}
      RenterService.addPayment(payment)
    },
    resetPayment(){
      this. payment = {};
      location.reload()
    }
  },
  created() {
    RenterService.getRental()
      .then((response) => {
        this.$store.commit("SET_RENTER_PROPERTY", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
  },
};
</script>

<style>
</style>