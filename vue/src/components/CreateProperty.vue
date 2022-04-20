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
      <input type="text" v-model="property.zip" />
      <br>
      <label for="price">Price $</label>
      <input type="number" v-model="property.price" />
      <label for="picture">Picture URL</label>
      <input type="text" v-model="property.picture" />
      <label for="available">Available</label>
      <input type="date" v-model="property.available" />
      <label for="bedrooms">Bedrooms</label>
      <input type="number" v-model="property.bedrooms" />
      <label for="bathrooms">Bathrooms</label>
      <input type="number" v-model="property.bathrooms" />
      <br>
      <label for="sqft">Square Feet</label>
      <input type="number" v-model="property.sqft" />
      <label for="shortDescription">Short Description</label>
      <input type="text" v-model="property.shortDescription" />
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
                available: "",
                bedrooms: "",
                bathrooms: "",
                sqft: "",
                shortDescription: ""

               
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