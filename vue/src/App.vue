<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'properties'}">Properties</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<!--
  property_id serial,
	-- user_id int NOT NULL,
	address varchar(100) NOT NULL,
	price decimal NOT NULL,
	picture text,
	available date NOT NULL,
	num_bedrooms decimal,
	num_bathrooms decimal,
	square_feet int,
	short_description text,
	long_description text,
  -->
