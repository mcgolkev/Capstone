<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input type="text" v-model="property.title" />
      <label for="price">Price</label>
      <input type="number" v-model="property.number" />
      <label for="available">Available</label>
      <input type="date" v-model="property.available" />
      <label for="bedrooms">Bedrooms</label>
      <input type="number" v-model="property.bedrooms" />
      <label for="bathrooms">Bathrooms</label>
      <input type="number" v-model="property.bathrooms" />
      <label for="sqft">Square Feet</label>
      <input type="number" v-model="property.sqft" />
      <label for="shortDescription">Short Description</label>
      <input type="text" v-model="property.shortDescription" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="saveProperty()">Save Property</button>
    </div>
  </form>
</template>

<script>
import propertyService from "../services/PropertyService.vue"

export default {
    name: "create-property",
    data(){
        return {
            property: {
                title: "",
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
        }
    }

}
</script>

<style>

</style>