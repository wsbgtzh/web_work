<script setup>
import { ref } from 'vue';
const content = ref('');
const emit = defineEmits(['post_a_post']);
const post_a_post = () => {
    if (content.value === "") return;
    emit('post_a_post', content.value);
    content.value = "";
}
</script>

<template>
    <div class="card">
        <div class="card-body">
            <div class="mb-3">
                <label for="edit_posts" class="form-label">编辑区</label>
                <textarea v-model="content" class="form-control" id="edit_posts" rows="3"></textarea>
                <button @click="post_a_post" type="button" class="btn btn-primary btn-sm">发帖</button>
            </div>
        </div>
    </div>
</template>

<style scoped>
.card {
    margin-top: 20px;
}

button {
    margin-top: 10px;
}
</style>