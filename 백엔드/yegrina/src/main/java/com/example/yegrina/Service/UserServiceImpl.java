package com.example.yegrina.Service;

import com.example.yegrina.Controller.Request.UserinfoRequest;
import com.example.yegrina.Entity.userinfo;
import com.example.yegrina.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String signup(UserinfoRequest userinfoRequest) throws Exception {
        //리퀘스트를 유저 엔티티에 씌우고 JPA에게 넘겨줌

       // Userinfo userinfo = signupRepository.findByUserName( userinfoRequest.getUserName());
        String testName =  userinfoRequest.getUserName();
        //Userinfo userinfo = signupRepository.findByUserName(testNa
        // );
        log.info("testName="+testName);

     String findName =   userRepository.findByUserName(testName);

     log.info("findName=" +findName );

        if(findName == null) {
            String resultMessage = "회원가입이 되었습니다.";
            // 유저 정보 담기.
            userinfo saveUserinfo = new userinfo(userinfoRequest.getUserName(), userinfoRequest.getUserPassWord(),
                    userinfoRequest.getUserTeam(), userinfoRequest.getUserAddress(), userinfoRequest.getUserPhone(),
                    userinfoRequest.getUserGrade(), userinfoRequest.getUserBirthday(), userinfoRequest.getUserFriend());
            // JPA 저장
            userRepository.save(saveUserinfo);


            return resultMessage;
        }
        else {
            return "이미 있는 팀원입니다.";
        }
    }

    @Override
    public List TeamZangLeaderList() throws Exception {

        List resultlist = userRepository.TeamZangLeaderList();
        return resultlist;
    }

    @Override
    public String login(UserinfoRequest userinfoRequest) throws Exception {
        final String result = "QWER!@#$";
        //아이디 존재여부 확인
        String findName = userRepository.findByUserName(userinfoRequest.getUserName());
        log.info("findName =" +findName);

        if(findName == null) {
            log.info("ID is undefined");
            return result;
        }
        else{
            log.info("ID is find");
            String userPassWord = userRepository.findPassWord(userinfoRequest.getUserName());
            log.info("userPassWord =" +userPassWord);
            if(userPassWord == null) {
                log.info("ID is find but Pw is undefined");
                return result;
            }
            else if(userPassWord.equals(userinfoRequest.getUserPassWord())){
                log.info("ID is find but Pw is find");
                Long userNo = userRepository.finByUserNo(userinfoRequest.getUserName());
                String resultUserNo = String.valueOf(userNo);
                return resultUserNo;
            }else{
                return result;
            }
        }


    }
}
