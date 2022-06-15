<template>
<div>
    <h2>예그리나 팀원등록</h2>
    <Signup-page-detail @submit="OnSubmit"/>

</div>
</template>

<script>
import axios from 'axios';
import SignupPageDetail from '@/components/SignupDetail/SignupPageDetail.vue'
export default {
    nmae: 'SignupPage',
    components:{
        SignupPageDetail
    },
    methods: {
        OnSubmit(payload) {
            console.log("payload:" , payload)
            const  {userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam} = payload
            axios.post('http://localhost:9999/Signup/register',{userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam})
            .then( (res) =>{
                alert(res.data)
            })

        }
    }
                                                              
}
</script>