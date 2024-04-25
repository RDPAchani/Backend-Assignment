package com.example.hourlyrecord.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.hourlyrecord.domain.EmployerRepository;
import com.example.hourlyrecord.domain.HourlyRecord;
import com.example.hourlyrecord.domain.HourlyRecordRepository;

@Controller
public class HourlyRecordController {

    @Autowired
	private HourlyRecordRepository repository; 

       @Autowired
    private EmployerRepository crepository;

    // handle login request
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

 // display all hourly records and total hours
    @RequestMapping(value= {"/", "/hourslist"})
    public String hourlyrecord(Model model) {	
        model.addAttribute("hourlyrecords", repository.findAll());
       
        model.addAttribute("totalHours", repository.calulateTotalHours());
        return "hourslist";
    }


// RESTful service to get all books
    @RequestMapping(value="/hourlyrecords", method = RequestMethod.GET)
    public @ResponseBody List<HourlyRecord> hourlyRecordRest() {	
        return (List<HourlyRecord>) repository.findAll();
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/hourlyrecords/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<HourlyRecord> findHourlyRest(@PathVariable("id") Long Id) {	
    	return repository.findById(Id);
    }  





  // add new hourly record
      @RequestMapping(value = "/add")
    public String addhours(Model model){
    	model.addAttribute("hourlyrecord", new HourlyRecord());
        model.addAttribute("employers", crepository.findAll());
        return "addhours";
    }     
    
    // save new or updated hourly record
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HourlyRecord hourlyrecord){
        repository.save(hourlyrecord);
        return "redirect:hourslist";
    }    
    
    //allow only admin role to access this endpoint
 @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletehours(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:/hourslist";
    }     

    //edit hourly record by id
    @GetMapping(value = "/edit/{id}")
    public String edithours(@PathVariable("id") Long Id, Model model) {
        model.addAttribute("hourlyrecord", repository.findById(Id));
        model.addAttribute("employers", crepository.findAll());
        return "updatehours";
    }

}
