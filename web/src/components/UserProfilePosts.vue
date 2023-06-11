<script setup>
import { useRoute } from 'vue-router';
import { computed } from 'vue';
import { useUserStore } from '../stores/user';
const route = useRoute();
const store = useUserStore();
const is_me = computed(() => route.params.userId === store.user.id)
const props = defineProps(['posts']);
const emit = defineEmits(['delete_a_post']);
const delete_a_post = post_id => {
    emit('delete_a_post', post_id);
}
</script>

<template>
    <div class="card" v-for="post in posts.posts">
        <div class="card-body">
            {{ post.content }}
            <button v-if="is_me" @click="delete_a_post(post.id)" type="button" class="btn btn-danger btn-sm">删除</button>
        </div>
    </div>
</template>

<style scoped>
.card {
    margin-bottom: 20px;
}

button {
    display: flex;
    float: right;
}
</style>