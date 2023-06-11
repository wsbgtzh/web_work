<script setup>
import { ref } from 'vue';
import { useUserStore } from '../stores/user';
const store = useUserStore();
const props = defineProps(['user']);

const follower_count = ref();
follower_count.value = props.user.follower_count;
const is_followed = ref(true);

const follow = () => {
    is_followed.value = false;
    follower_count.value++;
}

const unfollow = () => {
    is_followed.value = true;
    follower_count.value--;
}
</script>

<template>
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-3"><img class="img-fluid" :src=user.photo alt=""></div>
                <div class="col-9">
                    <div class="username">{{ user.username }}</div>
                    <div class="fans">粉丝数: {{ user.follower_count }}</div>
                    <button @click="unfollow" v-if="!is_followed" type="button" class="btn btn-secondary">取消关注</button>
                    <button @click="follow" v-else type="button" class="btn btn-primary btn-sm">+关注</button>
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