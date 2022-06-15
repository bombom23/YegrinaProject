import VueCookies from "vue-cookies";
import Vue from 'vue'
Vue.use(VueCookies)
import {
    FETCH_LOGINUSER,
    GET_TZ_LEADER_LIST
} from '@/store/mutation-types'
import axios from "axios";

export default {
    fetchLoginUser({commit}) {

        if(Vue.$cookies.get('loginName') !== null) {
            var data =  Vue.$cookies.get('loginName')           
        }else{
            data = null
        }

        commit(FETCH_LOGINUSER,data)
    },
    TeamZangAndReaderList({commit}) {

        return axios.get('http://localhost:9999/user/getTeamZangAndReaderList')
        .then( (res) => {
            commit(GET_TZ_LEADER_LIST,res.data)
        })
    }
    
}