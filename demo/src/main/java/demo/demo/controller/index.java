package demo.demo.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller 
@ResponseBody 

public class index {   

    @RequestMapping("/index")    
    public String retunString() {        
        
        return "This is the main page";    
    } 

}
