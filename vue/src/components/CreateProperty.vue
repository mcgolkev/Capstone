<template>
   <div class="tile is-parent is-8">
    <div id="this-is-bunches" class="tile is-vertical box">
  <form v-on:submit.prevent>
    <div class="field">
      <label for="addressLine1">Address Line 1</label>&nbsp; &nbsp;
      <input type="text" v-model="property.addressLine1" /><br/>
      <label for="addressLine2">Address Line 2</label> &nbsp; &nbsp;
      <input type="text" v-model="property.addressLine2" />  <br/>
      <label for="city">City</label>
      <input type="text" v-model="property.city" />    <br/>
      <label for="state">State</label>
      <input type="text" v-model="property.state" /> <br/>     
      <label for="zip">Zip</label>
      <input type="number" v-model="property.zip" /><br/><br/><br/>
      <label for="price">Price $</label>
      <input type="number" v-model="property.price" /><br/>
      <label for="picture">Picture URL</label>
      <input type="text" v-model="property.picture" /><br/>
      <label for="dateAvailable">Available Date</label>
      <input type="date" v-model="property.dateAvailable" /><br/>
      <label for="numBedrooms">Bedrooms</label>
      <input type="number" v-model="property.numBedrooms" /><br/>
      <label for="numBathrooms">Bathrooms</label>
      <input type="number" v-model="property.numBathrooms" /><br/>
      <label for="squareFeet">Square Feet</label>
      <input type="number" v-model="property.squareFeet" /><br/>
      <label for="shortDescription">Short Description</label>
      <input type="text" v-model="property.shortDescription" /><br/>
      <label for="longDescription">Long Description</label>
      <input type="text" v-model="property.longDescription" /><br/>
    </div>
    <div class="actions">
      <button type="submit" v-on:click="addProperty()" @click="resetProperty">Add Property</button>
      <button type="submit" v-on:click="saveProperty(property.propertyId)" @click="resetProperty">Save Property</button>
      <button type="submit" v-on:click="cancelProperty()" @click="resetProperty">Cancel</button>
    </div>
  </form>
  </div>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService.js"

export default {
    name: "create-property",
    data(){
        return {
            property: {
                addressLine1: "",
                addressLine2: "",
                city: "",
                state: "",
                zip: Number,
                price: Number,
                picture: "",
                dateAvailable: "",
                numBedrooms: Number,
                numBathrooms: Number,
                squareFeet: Number,
                shortDescription: "",
                longDescription: "",
                available: true,
                availableForRent: true
            }
        }
    },
    methods: {
        saveProperty(id){
           
            propertyService.update(id, this.property)
        },
        
    addProperty(){
          propertyService.addProperty(this.property)
          this.$router.push({ name: "home" });
    },
     cancelProperty(){
         
          this.$router.push({ name: "home" });
    },
    resetProperty(){
      this.property = {};
      location.reload()
    },
    }
}
</script>

<style>

</style>
