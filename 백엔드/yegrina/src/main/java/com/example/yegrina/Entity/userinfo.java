package com.example.yegrina.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name = "userinfo")
public class userinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserNo;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 20, nullable = false)
    private String userPassWord;

    @Column(length = 20, nullable = false)
    private String userTeam;

    @Column(length = 20, nullable = false)
    private String userAddress;

    @Column(length = 20, nullable = false)
    private String userPhone;

    @Column(length = 20, nullable = false)
    private String userGrade;

    @Column(length = 20, nullable = false)
    private String userBirthday;

    @Column(length = 20, nullable = false)
    private String userFriend;


    public userinfo(String UserName, String UserPassWord, String UserTeam , String UserAddress, String UserPhone, String UserGrade, String UserBirthday, String userFriend) {
        this.userName = UserName;
        this.userPassWord = UserPassWord;
        this.userTeam = UserTeam;
        this.userAddress = UserAddress;
        this.userPhone = UserPhone;
        this.userGrade = UserGrade;
        this.userBirthday = UserBirthday;
        this.userFriend = userFriend;


    }


}
