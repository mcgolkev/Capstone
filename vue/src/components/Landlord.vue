<template>
  <div>
    <div id="marginTitle">
      <h1 id="OverallPageTitleOutsideOfTitles">
        <center>Properties Available to Assign</center>
      </h1>
    </div>
    <div id="all">
      <div id="first-container" class="tile is-ancestor">
        <div
          class="rental-property-info"
          v-for="property in this.$store.state.renterProperty"
          v-bind:key="property.propertyId"
        >
          <div class="tile is-parent is-12">
            <div id="this-is-bunches" class="tile is-vertical box">
              <h2>
                <b>Property ID: {{ property.propertyId }}</b><br />
                <b>Address: </b><br />{{ property.addressLine1 }}
                {{ property.addressLine2 }}<br />
                {{ property.city }},
                {{ property.state }}
                {{ property.zip }}
              </h2>
              <div id="inline">
                <router-link
                  :to="{
                    name: 'add-property',
                    params: { id: property.propertyId },
                  }"
                  ><button class="inline" type="button">Edit Property</button>
                </router-link>
                <button
                  class="inline"
                  type="button"
                  v-on:click="deleteProperty(property.propertyId)"
                  @click="reloadPage"
                >
                  Delete Property
                </button>
              </div>

              <assign-renter :id="property.propertyId" />
            </div>
          </div>
        </div>

        <div class="tile is-vertical">
          <div id="center" class="tile box is-vertical">
            <div id="minWidth">
              <h1 id="OverallPageTitleOutsideOfTitles">
                <center>Currently Rented Properties Overview</center>
              </h1>

              <p id="this-is-bunches">
                <!-- /properties/rented -->
              </p>

              <div
                class="rented-properties"
                v-for="property in this.$store.state.rentedProperty"
                v-bind:key="property.propertyId"
              >
                <div class="tile is-parent is-4">
                  <div id="this-is-bunches" class="tile is-vertical box">
                    <h1>
                      Address: {{ property.addressLine1 }}
                      {{ property.addressLine2 }}
                      {{ property.city }}
                      {{ property.state }}
                      {{ property.zip }}
                    </h1>

                    <account-info :id="property.propertyId" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="tile box is-12 is-vertical">
          <h1 id="OverallPageTitleOutsideOfTitles">
            <center>Outstanding Maintenance Requests</center>
          </h1>
          <div class="maintenance">
            <div
              v-for="maint in this.$store.state.maintenance"
              v-bind:key="maint.maintenanceId"
            >
            <p>Maintenance ID: {{maint.maintenanceId}}</p>
              <p>Date: {{ maint.dateSubmitted }}</p>
              <p>Description: {{ maint.description }}</p>
              <div id="inline">
                <assign-worker :id="maint.maintenanceId" />
              </div>
              <br />
              <br />
            </div>
          </div>
        </div>
      </div>
    </div>
<div>
  <notification-list />
  </div>
  </div>
</template>

<script>
import LandlordService from "../services/LandlordService";
import AccountInfo from "./AccountInfo.vue";
import PropertyService from "../services/PropertyService";
import AssignRenter from "./AssignRenter.vue";
import AssignWorker from "./AssignWorker.vue";
import NotificationList from './NotificationList.vue';

export default {
  components: { AccountInfo, AssignRenter, AssignWorker, NotificationList },
  data() {
    return {
      rentInfo: {},
    };
  },
  methods: {
    getRentInfo(id) {
      LandlordService.getRentInfo(id).then((response) => {
        this.rentInfo = response.data;
        return this.rentInfo;
      });
    },
    deleteProperty(id) {
      PropertyService.deleteProperty(id).then((response) => {
        if (response.status == 201) {
          this.$router.push({ name: "Home" });
        }
      });
    },
    reloadPage() {
      location.reload();
    },
  },
  created() {
    LandlordService.get()
      .then((response) => {
        this.$store.commit("SET_RENTER_PROPERTY", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });

    LandlordService.getRented()
      .then((response) => {
        this.$store.commit("SET_RENTED_PROPERTY", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });

    LandlordService.getMaintenanceUnassigned()
      .then((response) => {
        this.$store.commit("SET_MAINTENANCE", response.data);
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
#inline {
  display: inline-flex;
  text-align: center;
}

#first-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
#this-is-bunches {
  display: flex;
  min-width: 300px;
}

#minWidth {
  min-width: 300px;
}

#marginTitle {
  margin: 15px;
}

.maintenance {
  margin: 30px;
}

#center {
  margin: 20px;
  display: flex;
}
</style>

<!--
-Add a way to register with role
-check puts
-check posts
-Logged in renter should be able to send landlord a request to rent

bind the edit property to the id and then send in as prop of property with the values


-->

