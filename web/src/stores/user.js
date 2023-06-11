import { ref } from 'vue';
import { defineStore } from 'pinia';
import $ from 'jquery';

export const useUserStore = defineStore('user', () => {
    const user = ref({
        id: "",
        username: "",
        photo: "",
        token: "",
        follower_count: 0,
        is_login: false,
        pulling_info: true,
    })

    const login = data => {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/user/account/token/",
            data: {
                username: data.username,
                password: data.password,
            },
            success(resp) {
                if (resp.error_message === "success") {
                    localStorage.setItem("jwt_token", resp.token);
                    user.value.token = resp.token;
                    data.success(resp);
                }  else {
                    data.error(resp);
                }
            },
            error(resp) {
                data.error(resp);
            }
        });
    }

    const getinfo = data => {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/user/account/info/",
            headers: {
                Authorization: "Bearer " + user.value.token,
            },
            success(resp) {
                if (resp.error_message === "success") {
                    user.value.id = resp.id;
                    user.value.username = resp.username;
                    user.value.photo = resp.photo;
                    user.value.follower_count = resp.follower_count;
                    user.value.is_login = true;
                    data.success(resp);
                } else {
                    data.error(resp); 
                }
            },
            error(resp) {
                data.error(resp);
            }
        });
    }

    const logout = () => {
        localStorage.removeItem("jwt_token");
        user.value.id = "";
        user.value.token = "";
        user.value.photo = "";
        user.value.username = "";
        user.value.is_login = false;
    }
    
    return { user, login, getinfo, logout }
})