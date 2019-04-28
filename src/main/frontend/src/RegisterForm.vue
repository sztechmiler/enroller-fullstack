<template>
  <form @submit.prevent="enter()">
    <label>Login</label>
    <input type="text" v-model="user.login">
    <label>Has≈Ço</label>
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
                return this.buttonLabel || 'Zarejestruj siƒô';
            },
            register() {
            	 this.$http.post('participants', this.user)
            	     .then(response => {
            	         // uda≥o siÍ
            	     })
            	     .catch(response => {
            	         // nie uda≥o sie     
            	     });
            	}
        }
    };
</script>
