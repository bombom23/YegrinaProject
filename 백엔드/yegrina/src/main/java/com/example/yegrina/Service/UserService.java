package com.example.yegrina.Service;


import com.example.yegrina.Controller.Request.UserinfoRequest;

import java.util.List;

public interface UserService {

    public String signup (UserinfoRequest userinfoRequest) throws  Exception;

    public  String login (UserinfoRequest userinfoRequest) throws  Exception;

    public List  TeamZangLeaderList () throws  Exception ;
}
