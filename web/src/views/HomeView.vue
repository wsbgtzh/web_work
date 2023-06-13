<script setup>
import Content from '../components/Content.vue';
import $ from 'jquery';
import { ref } from 'vue';
import { useUserStore } from '../stores/user';
import UserPublicPosts from '../components/UserPublicPosts.vue';
const store = useUserStore();

</script>

<template>
    <Content>
        <UserPublicPosts></UserPublicPosts>
    </Content>
</template>

<style scoped>
.container {
    margin-top: 20px;
}
</style>