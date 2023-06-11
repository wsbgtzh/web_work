<script setup>
import Content from '../components/Content.vue';
import $ from 'jquery';
import { ref } from 'vue';
import { useUserStore } from '../stores/user';

const store = useUserStore();
// $.ajax({
//     type: "post",
//     url: "http://localhost:8080/user/account/token/",
//     data: {
//         username: 'tzh',
//         password: '123',
//     },
//     // hears: {
//     //     Authorization: "Bearer " +
//     // }
//     success(resp) {
//         console.log(resp);
//     },
//     error(resp) {
//         console.log(resp);
//     }
// });

// $.ajax({
//     type: "post",
//     url: "http://localhost:8080/user/account/token/",
//     data: {
//         username: "tzh",
//         password: "123",
//     },
//     success(resp) {
//         console.log(resp);
//     },
//     error(resp) {
//         console.log(resp);
//     }
// });

// $.ajax({
//     type: "get",
//     url: "http://localhost:8080/user/userlist/",
//     headers: {
//         Authorization: "Bearer " + store.user.token,
//     },
//     success(resp) {
//         console.log(resp);
//     },
//     error(resp) {
//         console.log(resp);
//     }
// });

// $.ajax({
//     type: "post",
//     url: "http://localhost:8080/user/account/register/",
//     data: {
//         username: "b",
//         password: "pb",
//         confirmedPassword: "pb",
//     },
//     success(resp) {
//         console.log(resp);
//     },
//     error(resp) {
//         console.log(resp);
//     }
// });

</script>

<template>
    <Content>
    </Content>
</template>

<style scoped>
.container {
    margin-top: 20px;
}
</style>