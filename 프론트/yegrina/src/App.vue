<template>
<v-app>
  <Header-component/>
    <v-main>
      <router-view/>
    </v-main>
    <footer-component/>
  </v-app>
</template>

<script>
import footerComponent from './components/Footer/footerComponent.vue';
import HeaderComponent from './components/Header/HeaderComponent.vue';
export default {
  name: 'App',
  components: {
    footerComponent,HeaderComponent
  },

  data: () => ({
    //
  }),
};
</script>
