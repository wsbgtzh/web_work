<script setup>
import { useUserStore } from '../stores/user';
import { reactive, ref } from 'vue';
import $ from 'jquery';
import { Modal } from 'bootstrap/dist/js/bootstrap.js';
import router from '../router';
const store = useUserStore();
const public_posts = ref([]);
const content = ref('');

const refresh_publicpost = () => {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/getpublicpost/",
        headers: {
            Authorization: "Bearer " + store.user.token
        },
        success(resp) {
            public_posts.value = resp.reverse();
        },
        error(resp) {
            console.log(resp);
        }
    });
}
refresh_publicpost();

const public_post = () => {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/user/publicpost/",
        data: {
            user_id: store.user.id,
            content: content.value,
            username: store.user.username,
            photo: store.user.photo,
        },
        headers: {
            Authorization: "Bearer " + store.user.token
        },
        success(resp) {
            Modal.getInstance('#add-post-btn').hide();
            refresh_publicpost();
        },
        error(resp) {
            console.log(resp);
        }
    });
    content.value = "";
}

const open_profile = userId => {
    router.push({
        name: "userprofile",
        params: {
            userId
        }
    });
}
</script>

<template>
    <div class="row">
        <div class="col-1">
            <img class="img-fluid" :src="store.user.photo" alt="">
        </div>
        <div class="col-11">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary post_btn" data-bs-toggle="modal" data-bs-target="#add-post-btn">
                发布新鲜事
            </button>

            <!-- Modal -->
            <div class="modal fade" id="add-post-btn" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">发布帖子</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="form-floating">
                                <textarea v-model="content" class="form-control" placeholder="Leave a comment here"
                                    id="floatingTextarea2" style="height: 100px"></textarea>
                                <label for="floatingTextarea2">帖子内容</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button @click="public_post" type="button" class="btn btn-primary">发布</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="card posts_show" v-for="post in public_posts" @click="open_profile(post.userId)">
        <div class="card-body">
            <div class="row">
                <div class="col-1"><img class="img-fluid" :src="post.photo" alt=""></div>
                <div class="col-2 username">{{ post.username }}</div>
                <div class="col-9 post-content">{{ post.content }}</div>
            </div>
        </div>
    </div>
</template>

<style scoped>
img {
    border-radius: 50%;
}

.post_btn {
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.username {
    font-size: 20px;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.posts_show {
    margin-top: 30px;
}

.post-content {
    font-size: 30px;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    justify-content: center;
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