<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="role" class="sr-only">Role</label>
      <input type="role" id="role" class="form-control" 
        placeholder="Renter/Landlord/Staff"
        v-model="user.role" required/>

     <!-- <select class="sr-only">
        <option value="" selected disabled>Pick Role</option>
        <option v-for="role in role" :value="users.role" :key="users.role">{{users.role}}</option>
      </select> -->
      <!-- <input type="b-dropdown"/>
      <b-dropdown
      id="role"
      text="Select your role"
      class="sr-only">
      <b-dropdown-item>Renter</b-dropdown-item>
      <b-dropdown-item>Landlord</b-dropdown-item>
      <b-dropdown-item>Maintenance</b-dropdown-item>
      <b-dropdown-divider></b-dropdown-divider>
      <b-dropdown-item active>Active Action</b-dropdown-item>
      <b-dropdown-item disabled> Disabled Action</b-dropdown-item>
      </b-dropdown> -->

      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else if (this.user.role != 'Renter' && this.user.role != 'Landlord' && this.user.role != 'Staff') {
        this.registrationErrors =true;
        this.registrationErrorMsg = 'Role is not Renter, Landlord or Staff'
      }
      else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style></style>
