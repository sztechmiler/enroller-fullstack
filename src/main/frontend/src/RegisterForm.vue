<template>
  <form @submit.prevent="enter()">
    <label>Login</label>
    <input type="text" v-model="user.login">
    <label>Hasło</label>
    <input type="password" v-model="user.password">
    <button type="submit" @click ="register()">{{ labelOfTheButton }}</button>
     </form>

</template>

<script>

    export default {
        props: ["buttonLabel"],
        data() {
            return {
                user: {}
            };
        },
        methods: {
            enter() {
                this.$emit("login", this.user);
            }
        },
        computed: {
            labelOfTheButton() {
                return this.buttonLabel || 'Zarejestruj się';
            },
            register() {
            	 this.$http.post('participants', this.user)
            	     .then(response => {
            	         // uda�o si�
            	     })
            	     .catch(response => {
            	     alert("Sorry, but user with this name already exists");

            	     });
            	}
        }
    };
</script>


