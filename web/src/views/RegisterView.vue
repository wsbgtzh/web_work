<script setup>
import Content from '../components/Content.vue';
import { ref } from 'vue';
import { useUserStore } from '../stores/user';
import router from '../router';
import $ from 'jquery';

const store = useUserStore();
let username = ref("");
let password = ref("");
let confirmedPassword = ref("");
const error_message = ref('');

const register = () => {
    error_message.value = "";
    $.ajax({
        type: "post",
        url: "http://localhost:8080/user/account/register/",
        headers: {
            Authorization: "Breaer " + store.user.token,
        },
        data: {
            username: username.value,
            password: password.value,
            confirmedPassword: confirmedPassword.value,
        },
        success(resp) {
            if (resp.error_message === "success") {
                router.push({ name: 'login' });
            } else {
                error_message.value = resp.error_message;
            }
        },
        error(resp) {
            console.log(resp);
        }
    });
}

</script>

<template>
    <Content>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form>
                    <div class="mb-3">
                        <label for="username" class="form-label">用户名</label>
                        <input v-model="username" type="text" class="form-control" id="username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">密码</label>
                        <input v-model="password" type="password" class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="confirmedPassword" class="form-label">确认密码</label>
                        <input v-model="confirmedPassword" type="password" class="form-control" id="confirmedPassword">
                    </div>
                    <button @click.prevent="register" type="submit" class="btn btn-primary">注册</button>
                    <div class="error-message">{{ error_message }}</div>
                </form>
            </div>
        </div>
    </Content>
</template>

<style scoped>
.container {
    margin-top: 20px;
}

button {
    width: 100%;
}

.error-message {
    color: red;
}
</style>