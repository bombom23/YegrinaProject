import  {
    FETCH_LOGINUSER,
    GET_TZ_LEADER_LIST
 } from '@/store/mutation-types'

 export default {
     [FETCH_LOGINUSER] (state, payload) {
         state.loginName = payload
     },
     [GET_TZ_LEADER_LIST] (states,payload) {
        console.log("payload",payload)
        states.TeamZangAndReaderList = payload
     }
 }