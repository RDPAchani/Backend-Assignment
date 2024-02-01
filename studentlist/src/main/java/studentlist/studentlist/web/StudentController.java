package studentlist.studentlist.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import studentlist.studentlist.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/hello")
    public String hellopage(Model model) {
        // Create students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        // Add students to the model
        model.addAttribute("students", students);

        return "hello";

    }
}


