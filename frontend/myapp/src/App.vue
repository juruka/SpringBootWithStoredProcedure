<template>
  <div id="app">
    <h1>MyHomePage</h1>
    <ul>
    <li>
      <my-home-page></my-home-page>
    </li>
  </ul>
  </div>
</template>

<script>
import MyHomePage from "./components/MyHomePage.vue";

export default {
  name: "App",
  components:{
    MyHomePage,
  }
};

</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
