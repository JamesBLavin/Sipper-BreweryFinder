<template>
  <div id="login">
    <img src="../assets/clink.png" alt="beerglasses">
    <form @submit.prevent="login">
      <h1 >giddy up partner</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <input type="text" id="username" class="inputboxes" v-model="user.username" required autofocus placeholder="username"/>
      </div>
      <div class="form-input-group">
        <input type="password" id="password" class="inputboxes" v-model="user.password" required placeholder="password"/>
      </div>
      <button type="submit">sign in</button>
      <p>
      <router-link :to="{ name: 'register' }" id="reg-link">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push(this.$store.state.path);
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
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
  background:white;
  border: solid 5px white;
  border-radius: 10px;
}

button:hover {
  font-weight: bold;
}

.inputboxes {
  border: solid 5px white;
  border-radius: 10px;

}

div {
  background: #4a3415;
  max-width: 33%;
  margin-left: 33%;
  align-content: center;
  border-radius: 25px;
  color: white;
}

#reg-link {
  color: white;
}

h1 {
  color: white;
}
</style>