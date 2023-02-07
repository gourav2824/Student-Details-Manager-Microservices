package gourav.studentdetailsmanager.studentservice.controller;

import gourav.studentdetailsmanager.studentservice.response.StudentResponse;
import gourav.studentdetailsmanager.studentservice.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }
}
