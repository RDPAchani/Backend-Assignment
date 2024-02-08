package demo.demo.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller 
@ResponseBody 

public class contact {   

    @RequestMapping("/contact")    
    public String returnString() {        
        
        return "This is the contact page";    
    } 

}