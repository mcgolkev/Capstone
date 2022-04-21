<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="addressLine1">Address</label>
      <input type="text" v-model="property.addressLine1" />
      <label for="addressLine2">Address Line 2</label>
      <input type="text" v-model="property.addressLine2" />  
      <label for="city">City</label>
      <input type="text" v-model="property.city" />    
      <label for="state">State</label>
      <input type="text" v-model="property.state" />      
      <label for="zip">Zip</label>
      <input type="number" v-model="property.zip" />
      <br>
      <label for="price">Price $</label>
      <input type="number" v-model="property.price" />
      <label for="picture">Picture URL</label>
      <input type="text" v-model="property.picture" />
      <label for="dateAvailable">Available Date</label>
      <input type="date" v-model="property.dateAvailable" />
      <label for="numBedrooms">Bedrooms</label>
      <input type="number" v-model="property.numBedrooms" />
      <label for="numBathrooms">Bathrooms</label>
      <input type="number" v-model="property.numBathrooms" />
      <br>
      <label for="squareFeet">Square Feet</label>
      <input type="number" v-model="property.squareFeet" />
      <label for="shortDescription">Short Description</label>
      <input type="text" v-model="property.shortDescription" />
      <label for="longDescription">Long Description</label>
      <input type="text" v-model="property.longDescription" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="addProperty()">Add Property</button>
      <button type="submit" v-on:click="saveProperty()">Save Property</button>
      <button type="submit" v-on:click="deleteProperty()">Delete Property</button>
    </div>
  </form>
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
                zip: "",
                price: "",
                picture: "",
                dateAvailable: "",
                numBedrooms: "",
                numBathrooms: "",
                squareFeet: "",
                shortDescription: "",
                longDescription: ""

               
            }
        }
    },
    methods: {
        saveProperty(){
            propertyService.addProperty(this.property).then((response) => {
                if (response.status == 201){
                    this.$router.push({name: 'Home'});
                }
            })
        },
        deleteProperty(){
          propertyService.deleteProperty(this.property).then((response) => {
                if (response.status == 201){
                    this.$router.push({name: 'Home'});
                }
            })
    }, 
    addProperty(){
          propertyService.addProperty(this.property).then((response) => {
                if (response.status == 201){
                    this.$router.push({name: 'Home'});
                }
            })
    },
    }
}
</script>

<style>

</style>