<template>
  <div id="app">
    <h1>
      <img src="./assets/logo.svg" alt="Enroller" class="logo">
      System do zapisów na zajęcia
    </h1>
    <button @click="loginform = true" :class="loginform ? '' : 'button-outline'">Zaloguj się</button>
    <button @click="loginform = false" :class="loginform? 'button-outline' : ''">Zarejestruj się</button>
    
    <div v-if="authenticatedUsername">
      <h2>Witaj {{ authenticatedUsername }}!
        <a @click="logout()" class="float-right  button-outline button">Wyloguj</a>
      </h2>
      <meetings-page :username="authenticatedUsername"></meetings-page>
    </div>
    <div v-else-if="loginform">
      <login-form @login="login($event)"></login-form>
    </div>
    <div v-else>
      <register-form @login="register($event)"></register-form>
    </div>
  </div>
</template>

<script>
    import "milligram";
    import LoginForm from "./LoginForm";
    import RegisterForm from "./RegisterForm";
    import MeetingsPage from "./meetings/MeetingsPage";

    export default {
        components: {LoginForm, MeetingsPage, RegisterForm},
        data() {
            return {
                authenticatedUsername: "",
                loginform: true,
            };
        },
        methods: {
            login(user) {
                this.authenticatedUsername = user.login;
            },
            logout() {
                this.authenticatedUsername = '';
            }
    }};
</script>

<style>
  #app {
    max-width: 1000px;
    margin: 0 auto;
  }

  .logo {
    vertical-align: middle;
  }
</style>

