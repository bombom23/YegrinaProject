package com.example.yegrina.Controller;

import com.example.yegrina.Controller.Request.UserinfoRequest;
import com.example.yegrina.Service.UserService;
import com.example.yegrina.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> signup (@RequestBody  @Validated UserinfoRequest userinfoRequest )  throws  Exception{

        log.info("Userinfo :" +userinfoRequest);
       String resultMessage = userService.signup(userinfoRequest);


        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody  @Validated UserinfoRequest userinfoRequest )  throws  Exception{

        log.info("Userinfo :" +userinfoRequest);
        String resultMessage = userService.login(userinfoRequest);


        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }
    @GetMapping("/getTeamZangAndReaderList")
    public  ResponseEntity<JSONArray> getTeamZangAndReaderList () throws  Exception{

       List TeamZangLeaderList = userService.TeamZangLeaderList();
        log.info("List" + TeamZangLeaderList);
        //리스트를 Vue 에서 Data 로 활용할수있게 Hash맵으로 전환한다
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray componentArray = new JSONArray();
            for (Object member :  TeamZangLeaderList){
                log.info("member = " + member);
                if(member.equals("테스트")) {
                    jsonObject.put("text", TeamZangLeaderList.get(TeamZangLeaderList.indexOf(member)));
                    jsonObject.put("value", TeamZangLeaderList.get(TeamZangLeaderList.indexOf(member)));
                    componentArray.put(jsonObject);
                }
                if(member.equals("서은비")) {
                    int i = 1;
                    String dd  = Integer.toString(i);
                    jsonObject1.put("text",TeamZangLeaderList.get(TeamZangLeaderList.indexOf(member)));
                    jsonObject1.put("value",TeamZangLeaderList.get(TeamZangLeaderList.indexOf(member)));
                    componentArray.put(jsonObject1);
                }

            }
        log.info("componentArray" + componentArray);


        return  new ResponseEntity<>(componentArray,HttpStatus.OK);
    }

}
