<script setup>
import Content from '../components/Content.vue';
import UserProfileInfo from '../components/UserProfileInfo.vue';
import UserProfileWrite from '../components/UserProfileWrite.vue';
import UserProfilePosts from '../components/UserProfilePosts.vue';
import { ref, reactive, computed } from 'vue';
import $ from 'jquery';
import { useUserStore } from '../stores/user';
import { useRoute } from 'vue-router';

const store = useUserStore();

const posts = reactive({});
const route = useRoute();
const userId = route.params.userId;
const is_me = computed(() => store.user.id === userId);
const user = reactive({});
$.ajax({
    type: "get",
    url: "http://localhost:8080/user/getinfo/",
    data: {
        userId: userId,
    },
    headers: {
        Authorization: "Bearer " + store.user.token,
    },
    success(resp) {
        user.id = resp.id;
        user.username = resp.username;
        user.photo = resp.photo;
        user.follower_count = resp.follower_count;
    },
    error(resp) {
        console.log(resp);
    }
});



$.ajax({
    type: "get",
    url: "http://localhost:8080/user/postlist/",
    data: {
        user_id: userId,
    },

    headers: {
        Authorization: "Bearer " + store.user.token,
    },

    success(resp) {
        posts.count = resp.length;
        posts.posts = resp;
    },
    error(resp) {
        console.log(resp);
    }
});

const post_a_post = content => {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/user/post/add/",
        data: {
            content: content,
        },
        headers: {
            Authorization: "Bearer " + store.user.token,
        },
        success(resp) {
            if (resp.error_message === 'success') {
                posts.count++;
                posts.posts.push({ userId: store.user.id, content: content });
            }
        },
        error(resp) {
            console.log(resp);
        }
    });
}

const delete_a_post = post_id => {
    $.ajax({
        type: "delete",
        url: "http://localhost:8080/user/post/delete/",
        data: {
            id: post_id,
        },
        headers: {
            Authorization: "Bearer " + store.user.token,
        },
        success(resp) {
            if (resp.error_message === "success") {
                posts.posts = posts.posts.filter(post => post_id !== post.id);
                posts.count = posts.posts.length;
            }
        }
    });
}
</script>

<template>
    <Content>
        <div class="row">
            <div class="col-3">
                <UserProfileInfo :user="user"></UserProfileInfo>
                <UserProfileWrite v-if="is_me" @post_a_post="post_a_post"></UserProfileWrite>
            </div>
            <div class="col-9">
                <UserProfilePosts :posts="posts" @delete_a_post="delete_a_post"></UserProfilePosts>
            </div>
        </div>
    </Content>
</template>

<style scoped>
.container {
    margin-top: 20px;
}
</style>