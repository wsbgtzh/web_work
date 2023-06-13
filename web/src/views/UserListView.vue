<script setup>
import Content from '../components/Content.vue';
import $ from 'jquery';
import { useUserStore } from '../stores/user';
import { ref } from 'vue';
import router from '../router';
const store = useUserStore();
const userlist = ref();
$.ajax({
    type: "get",
    url: "http://localhost:8080/user/userlist/",
    headers: {
        Authorization: "Bearer " + store.user.token,
    },
    data: {
        user_id: store.user.id
    },
    success(resp) {
        userlist.value = resp;
    },
    error(resp) {
        console.log(resp);
    }
});

const open_profile = userId => {
    if (store.user.is_login) {
        router.push({
            name: "userprofile",
            params: {
                userId
            }
        })
    }
}
</script>

<template>
    <Content>
        <div class="card" v-for="user in userlist" @click="open_profile(user.id)">
            <div class="card-body">
                <div class="row">
                    <div class="col-1">
                        <img class="img-fluid" :src="user.photo">
                    </div>
                    <div class="col-11">
                        <div class="username">{{ user.username }}</div>
                        <div class="follow-count">{{ user.followerCount }}</div>
                    </div>
                </div>
            </div>
        </div>
    </Content>
</template>

<style scoped>
.container {
    margin-top: 20px;
}

.card {
    margin-bottom: 20px;
}

img {
    border-radius: 50%;
}

.username {
    font-weight: bold;
    height: 50%;
}

.follow-count {
    font-size: 12px;
    color: gray;
    height: 50%;
}

.card {
    margin-bottom: 20px;
    cursor: pointer;
}

.card:hover {
    box-shadow: 2px 2px 10px red;
    transition: 500ms;
}
</style>