<template>
  <div id="app">
      <b-navbar>
        <template #brand>
            <b-navbar-item tag="router-link" :to="{ path: '/' }">
                <!-- <img
                    src="logo"
                    alt="logo"
                > -->
                ScrumLords
            </b-navbar-item>
        </template>
        <template #start>
            <b-navbar-item>
                <router-link v-bind:to="{ name: 'home' }">Home</router-link>
            </b-navbar-item>
            <b-navbar-item>
                <router-link v-bind:to="{ name: 'properties' }">Properties</router-link>
            </b-navbar-item>
            <b-navbar-item>
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </b-navbar-item>
        </template>
    </b-navbar>
    <router-view />
  </div>
</template>
