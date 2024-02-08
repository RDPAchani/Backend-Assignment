package demo.demo.controller;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller 
@ResponseBody 

public class hello {

    @RequestMapping("/hello")    
    public String call(@RequestParam(name="location") String locationName, 
    @RequestParam(name="name") String Name)
     {
        return "Welcome to the " + locationName +" "+ Name+"!";    
    
    }
}
