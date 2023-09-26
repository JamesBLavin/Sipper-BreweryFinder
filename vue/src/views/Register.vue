<template>
  <div id="register" class="text-center">
    <img src="../assets/clink.png" alt="beerglasses">
    <form @submit.prevent="register">
      <h1>create account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">username</label>
        <input type="text" id="username" v-model="user.username" required autofocus class="inputboxes"/>
      </div>
      <div class="form-input-group">
        <label for="password">password</label>
        <input type="password" id="password" v-model="user.password" required  class="inputboxes"/>
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">confirm password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required  class="inputboxes"/>
      </div>
      <button type="submit">create account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
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
        role: 'user',
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
      } else {
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

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

button {
  background:tan;
  border: solid 5px tan;
  border-radius: 10px;
}

.inputboxes {
  border: solid 5px white;
  border-radius: 10px;
}

button:hover {
  font-weight: bold;
}
</style>
