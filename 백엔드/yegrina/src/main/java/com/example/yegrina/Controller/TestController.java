package com.example.yegrina.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TestController {



    @GetMapping("/summit")
    public ResponseEntity<String> testPage () {



        String request = "통신완료";
        return new ResponseEntity<String>(request,HttpStatus.OK);
    }
    
    @GetMapping("/dd")
    public String testString () {
        return "/test";
    }

}
