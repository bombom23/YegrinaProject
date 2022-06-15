<template>
<div>
     <form @submit.prevent="onSubmit">
        
        <v-container id="SignupForm" style="max-width:350px">
         <div>
            <div class="row">
            </div>
            <p>팀원 포지션</p>
            <v-select v-model="userGrade" :items="positions" required></v-select>            
            <v-text-field  class="pl-3 pr-3"  v-model="userName"
            label="이름" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
             <v-text-field  class="pl-3 pr-3"   required  v-model="userPassWord"
            label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
            <v-text-field  class="pl-3 pr-3"  :rules="pscheck" required  v-model="userPassWordCheck"
            label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
             <v-text-field class="pl-3 pr-3"   required v-model="userPhone"
            label="휴대전화" type="text" prepend-icon="mdi-phone" flat solo>
            </v-text-field>
             <v-text-field class="pl-3 pr-3"  required v-model="userBirthday"
            label="주소" type="Date" prepend-icon="mdi-home-map-marker" flat solo>
            </v-text-field>
             <v-text-field class="pl-3 pr-3"  required v-model="userAddress"
            label="주소" type="text" prepend-icon="mdi-home-map-marker" flat solo>
            </v-text-field>
             <v-btn class="" @click="OnSubmit">회원가입</v-btn>
           <v-btn class="" route :to="{ name: 'Home' }">취소</v-btn>
               
        </div>
         
        </v-container>
    
    </form>
   
</div>
</template>

<script>
//import axios from 'axios';
export default {
    name: 'SignupPageDetail',
    data () {
        return {
            userName: '',
            userPassWord: '',
            userPassWordCheck: '',
            userGrade: '',
            userAddress: '',
            userBirthday: '',
            userPhone: '',
            userTeam: '예그리나',
            pscheck: [v => this.userPassWord ===v || '비밀번호가 일치하지않습니다'
                    ],
            positions: [ 
               {text: '팀장', value: '팀장'},
               {text: '리더', value: '리더'} ,
               {text: '팀원', value: '팀원'}
                
            ]        

        }
    },
    methods : {
         OnSubmit() {
            const  {userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam} = this
            this.$emit('submit', {userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam})
    }

}
}
</script>