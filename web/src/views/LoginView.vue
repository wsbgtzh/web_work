<script setup>
import Content from '../components/Content.vue';
import { ref } from 'vue';
import { useUserStore } from '../stores/user';
import router from '@/router/index.js';
const store = useUserStore();
let username = ref('');
let password = ref('');
let error_message = ref('');

const jwt_token = localStorage.getItem("jwt_token");
if (jwt_token) {
    store.user.token = jwt_token;
    store.getinfo({
        success() {
            router.push({ name: 'home' });
            store.user.pulling_info = false;
        },
        error() {
            store.user.pulling_info = false;
        }
    })
} else {
    store.user.pulling_info = false;
}
const login = () => {
    error_message.value = "";
    store.login({
        username: username.value,
        password: password.value,
        success(resp) {
            store.getinfo({
                success(resp) {
                    router.push({ name: "home" });
                },
                error(resp) {
                    console.log(resp);
                }
            });
        },
        error(resp) {
            console.log(resp);
            error_message.value = "用户名或密码错误";
        }
    });
}

</script>

<template>
    <Content v-if="!store.user.pulling_info">
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
                    <button @click.prevent="login" type="submit" class="btn btn-primary">登录</button>
                    <div class="error_message">{{ error_message }}</div>
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

.error_message {
    color: red;
}
</style>