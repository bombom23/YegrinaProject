<template>
<div>
<v-card class="overflow-hidden">
    <v-app-bar
      absolute
      color="#fcb69f"
      dark
      shrink-on-scroll
      src="https://picsum.photos/1920/1080?random"
      scroll-target="#scrolling-techniques-2"
    >
      <template v-slot:img="{ props }">
        <v-img
          v-bind="props"
          gradient="to top right, rgba(19,84,122,.5), rgba(128,208,199,.8)"
        ></v-img>
      </template>

      <v-app-bar-nav-icon
      @click.stop="sideMenu  = !sideMenu"
      ></v-app-bar-nav-icon>
     <v-app-title  style="margin-left: 100px;"><v-btn @click="GOHOME()" color="transparent" elevation="0" >YEGRINa</v-btn></v-app-title>

      <v-spacer></v-spacer>

    <v-dialog
      v-model="dialog"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="transparent" elevation="0" v-bind="attrs"  v-on="on" >
          <v-icon>mdi-account-plus</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="text-h5">팀원등록</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
         <form @submit.prevent="onSubmit">
        
        <v-container id="SignupForm" style="max-width:350px">
         <div>
            <div class="row">
            </div>
             <p>팀원 등급</p>
            <v-select v-model="userGrade" :items="positions" required></v-select>
            <p>친구</p>
            <v-select v-model="userFriend" :items="TeamzangAndLeaderList2" required></v-select>           
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
               
        </div>
         
        </v-container>
    
    </form>


            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
          >
            Close
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="OnSubmit()"
          >
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <!---->

<v-dialog v-if="this.loginUser == null"
      v-model="loginDialog"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="transparent" elevation="0" v-bind="attrs"  v-on="on" >
          <v-icon>mdi-login</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="text-h5">로그인</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>

             <v-text-field  class="pl-3 pr-3"  v-model="loginName"
            label="이름" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
             <v-text-field  class="pl-3 pr-3"   required  v-model="loginPassword"
            label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>


            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="loginDialog = false"
          >
            취소
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="Dologin()"
           
          >
            로그인
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  <!--로그아웃일때-->
  <v-dialog v-else-if="this.loginUser !== null "
      v-model="loginOutDialog"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="transparent" elevation="0" v-bind="attrs"  v-on="on" >
          <v-icon>mdi-power</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="text-h5">로그아웃</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <p>로그아웃을 하시겠습니까?</p>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="loginOutDialog = false"
          >
            취소
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="logOut()"
          >
            로그아웃
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog> 

      <v-btn v-if="this.loginUser !== null" icon @click="checking">
        {{loginUser}}
      </v-btn>
      
    </v-app-bar>
    
    <v-sheet max-height="auto">
      <v-container style="height: 120px;"></v-container>
    </v-sheet> 
  </v-card>
  <!--사이드 바 그리기 시작 -->
     <v-navigation-drawer
      v-model="sideMenu"
      absolute
      bottom
      temporary
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group
          
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-title>Foo</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Bar</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <!-- 사이드 바 그리기 끝 -->
</div>
</template>

<script>
import axios from 'axios'
import VueCookies from "vue-cookies";
import Vue from 'vue'
import { mapState,mapActions } from 'vuex';


Vue.use(VueCookies);

  export default {
    name: 'HeaderComponent',
    computed:{
      ...mapState('loginName','TeamZangAndReaderList'),
    },
    data() {
      return {
        sideMenu:false,
        sayHello: '님 반갑습니다.',
        loginOutDialog: false,
        loginUser: null,
        dialog: false,
        loginDialog: false,
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
                
            ],
            loginName: '',
            loginPassword: '',
            TeamzangAndLeaderList2: [
              {text: '', value: ''}
            ]

      }
    },
    components: {

    },
    methods: {
      ...mapActions(['TeamZangAndReaderList']),
     // ...mapActions (['fetchLoginUser']),
      GOHOME () {
       // this.$router.go() 임시 테스트 버튼
       this.TeamZangAndReaderList();
       console.log("결과적으로 온값 = ",this.$store.state.TeamZangAndReaderList)
        this.TeamzangAndLeaderList2[0].text =this.$store.state.TeamZangAndReaderList
        this.TeamzangAndLeaderList2[0].value =this.$store.state.TeamZangAndReaderList
      },
      checking() {
        // 디버깅
        console.log(this.loginUser)
      },
      OnSubmit() {
            
            const  {userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam} = this
            axios.post('http://localhost:9999/user/register',{userName , userPassWord, userGrade, userAddress, userBirthday, userPhone, userTeam})
            .then( (res) =>{
                alert(res.data)
                if(res.data == "이미 있는 팀원입니다."){
                  this.dialog =true;
                }else{
                    this.$router.go()
                }
                
            })

        },
        Dologin() {
          const {loginName,loginPassword} =this
          axios.post('http://localhost:9999/user/login',{userName:loginName,userPassWord:loginPassword})
          .then((res) => {
           
            if(res.data == "QWER!@#$"){
              alert("일치하는 정보가 없습니다.")
              this.login = true;
            }
            else{
               console.log(res.data)//로그인성공시 반환되는 userNo
              alert("로그인이 되었습니다.")
              Vue.$cookies.set('loginName',loginName,'1h')
              Vue.$cookies.set('loginNo',res.data,'1h')
              this.loginUser = Vue.$cookies.get('loginName')
              //this.fetchLoginUser();
              this.loginDialog = false;
             //this.$router.go()
            }
          })
        },
        logOut(){
          this.loginUser =null,
          Vue.$cookies.remove('loginName')
          Vue.$cookies.remove('loginNo')
          this.$router.go()
        }
    },
    created() {
      if(this.loginUser == null) {
         this.loginUser = Vue.$cookies.get('loginName')
      }else {
        this.loginUser = null
      }
      
    },
    mounted() {

    }
  }
</script>
<style>
</style>