<script setup>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import NavBar from './components/NavBar.vue';
</script>

<template>
  <NavBar></NavBar>
  <RouterView :key="$route.fullPath" />
</template>

<style></style>