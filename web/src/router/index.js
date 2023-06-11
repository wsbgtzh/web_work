import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue';
import UserListView from '@/views/UserListView.vue';
import UserProfileView from '@/views/UserProfileView.vue';
import NotFound from '@/views/NotFound.vue';
import LoginView from '@/views/LoginView.vue';
import RegisterView from '@/views/RegisterView.vue';
import { useUserStore } from '../stores/user';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: 'home',
    },
    {
      path: '/home/',
      name: 'home',
      component: HomeView,
      meta: {
        requestAuth: true,
      }
    },
    {
      path: '/userlist/',
      name: 'userlist',
      component: UserListView,
      meta: {
        requestAuth: true,
      }
    },
    { 
      path: '/userprofile/:userId/',
      name: 'userprofile',
      component: UserProfileView,
      meta: {
        requestAuth: true,
      }
    },
    {
      path: '/user/account/login/',
      name: 'login',
      component: LoginView,
      meta: {
        requestAuth: false,
      }
    },
    {
      path: '/user/account/register/',
      name: 'register',
      component: RegisterView,
      meta: {
        requestAuth: false,
      }
    },
    {
      path: '/404/',
      name: '404',
      component: NotFound,
      meta: {
        requestAuth: false,
      }
    },
    {
      path: '/:catchAll(.*)',
      redirect: '/404/'
    },
  ]
})

router.beforeEach((to, from, next) => {
   if (to.meta.requestAuth && !useUserStore().user.is_login) {
    next({name: "login"});
   } else {
    next();
   }
})

export default router
