<script setup>
import { useUserStore } from '../stores/user';
import router from '@/router/index';
import { ref, onBeforeMount } from 'vue';
const store = useUserStore();


const logout = () => {
    store.logout();
    router.push({ name: "login" });
}

const to_user = userId => {
    if (store.user.is_login) {
        router.push({
            name: "userprofile",
            params: {
                userId,
            }
        })
    }
}
</script>

<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home' }">MySpace</router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link class="nav-link" aria-current="page" :to="{ name: 'home' }">首页</router-link>
                    </li>
                    <li v-if="store.user.is_login" class="nav-item">
                        <router-link class="nav-link" :to="{
                            name: 'userprofile', params: {
                                userId: store.user.id
                            }
                        }">用户动态</router-link>
                    </li>
                    <li v-if="store.user.is_login" class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'userlist' }">好友列表</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item" v-if="!store.user.is_login && !store.user.pulling_info">
                        <router-link class="nav-link" :to="{ name: 'login' }">登录</router-link>
                    </li>
                    <li class="nav-item" v-else>
                        <a @click="to_user(store.user.id)" style="cursor: pointer;" class="nav-link">{{
                            store.user.username
                        }}</a>
                    </li>
                    <li class="nav-item" v-if="!store.user.is_login && !store.user.pulling_info">
                        <router-link class="nav-link" :to="{ name: 'register' }">注册</router-link>
                    </li>
                    <li class="nav-item" v-else>
                        <a @click="logout" class="nav-link" style="cursor: pointer;">退出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<style scoped></style>