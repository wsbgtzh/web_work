<script setup>
import { ref, computed } from 'vue';
import { useUserStore } from '../stores/user';
import { useRoute } from 'vue-router';
import $ from 'jquery';
const store = useUserStore();
const props = defineProps(['user']);

const follower_count = ref();
const is_followed = ref();
const follow_id = ref();
const route = useRoute();
const is_me = computed(() => route.params.userId === store.user.id);
const refresh_follow_info = () => {
    if (!is_me.value)
        $.ajax({
            type: "get",
            url: "http://localhost:8080/user/followinfo/",
            data: {
                user_id: store.user.id,
                target_id: route.params.userId,
            },
            headers: {
                Authorization: "Bearer " + store.user.token
            },
            success(resp) {
                if (resp.followed === 'true')
                    is_followed.value = true;
                else is_followed.value = false;
                follow_id.value = resp.follow_id;
            },
            error(resp) {
                console.log(resp);
            }
        });
    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/getinfo/",
        data: {
            userId: route.params.userId,
        },
        headers: {
            Authorization: "Bearer " + store.user.token,
        },
        success(resp) {
            follower_count.value = parseInt(resp.follower_count);
        },
        error(resp) {
            console.log(resp);
        }
    });
}

refresh_follow_info();

const follow = () => {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/user/updatefollow/",
        data: {
            follow_id: follow_id.value,
            followed: 'true',
        },
        headers: {
            Authorization: "Bearer " + store.user.token
        },
        success(resp) {
            follower_count.value++;
            is_followed.value = true;
            $.ajax({
                type: "post",
                url: "http://localhost:8080/user/account/updateinfo",
                data: {
                    user_id: route.params.userId,
                    follow_count: follower_count.value,
                },
                headers: {
                    Authorization: "Bearer " + store.user.token
                },
                success(resp) {
                    refresh_follow_info();
                }
            });
        },
        error(resp) {
            console.log(resp);
        }
    });
}

const unfollow = () => {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/user/updatefollow/",
        data: {
            follow_id: follow_id.value,
            followed: 'false',
        },
        headers: {
            Authorization: "Bearer " + store.user.token
        },
        success(resp) {
            follower_count.value--;
            is_followed.value = false;
            $.ajax({
                type: "post",
                url: "http://localhost:8080/user/account/updateinfo",
                data: {
                    user_id: route.params.userId,
                    follow_count: follower_count.value,
                },
                headers: {
                    Authorization: "Bearer " + store.user.token
                },
                success(resp) {
                    refresh_follow_info();
                }
            });
        },
        error(resp) {
            console.log(resp);
        }
    });
}
</script>

<template>
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-3"><img class="img-fluid" :src=user.photo alt=""></div>
                <div class="col-9">
                    <div class="username">{{ user.username }}</div>
                    <div class="fans">粉丝数: {{ follower_count }}</div>
                    <button v-if="!is_me && is_followed" @click="unfollow" type="button"
                        class="btn btn-secondary">取消关注</button>
                    <button v-else-if="!is_me && !is_followed" @click="follow" type="button"
                        class="btn btn-primary btn-sm">+关注</button>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
img {
    border-radius: 50%;
}

.username {
    font-weight: bold;
}

.fans {
    font-size: 12px;
    color: gray
}

button {
    padding: 2px 4px;
    font-size: 12px;
    margin-top: 10px;
}
</style>