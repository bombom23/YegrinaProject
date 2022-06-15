package com.example.yegrina.Controller.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserinfoRequest {

    //유저정보 저장공간
    private  Long   userNo;
    private  String userAddress;
    private  String userBirthday;
    private  String userGrade;
    private  String userName;
    private  String userPassWord;
    private  String userPhone;
    private  String userTeam;
    private  String userFriend;



}
