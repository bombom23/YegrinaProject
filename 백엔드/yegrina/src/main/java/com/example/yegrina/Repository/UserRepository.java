package com.example.yegrina.Repository;

import com.example.yegrina.Entity.userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<userinfo,Long> {

    @Query("select u.userName from userinfo u where u.userName =:name")
    public String findByUserName(@Param("name")String name);
    @Query("select u.userPassWord from userinfo u where u.userName =:name")
    public String findPassWord(@Param("name") String name);

    @Query("select u.UserNo from userinfo u where u.userName =:name")
    public Long finByUserNo(@Param("name")  String name);

    @Query("select u.userName from userinfo u where u.userGrade = '리더' or u.userGrade ='팀장'")
    public List TeamZangLeaderList ();

}