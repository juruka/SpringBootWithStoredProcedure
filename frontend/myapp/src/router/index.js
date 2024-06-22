import Vue from 'vue';
import VueRouter from 'vue-router';
import MyHomePage from '../components/MyHomePage.vue';
import AddNew from '../components/AddNew.vue';
import ShowAll from '../components/ShowAll.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'MyHomePage',
        component: MyHomePage
    },
    {
        path: '/add',
        name: 'add',
        component: AddNew
    },
    {
        path: '/show',
        name: 'ShowAll',
        component: ShowAll
    }
];

const router = new VueRouter({
    routes
});

export default router;
