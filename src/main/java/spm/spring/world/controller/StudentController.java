package spm.spring.world.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spm.spring.world.model.Student;
import spm.spring.world.response.ResponseModel;
import spm.spring.world.service.StudentService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller     // Useful to create the RESTful webservices.
public class StudentController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    StudentService service;

    // Save student entity in the h2 database.
    // @PostMapping annotation handles the http post request matched with the given uri.
    // @RequestBody annotation binds the http request body to the domain object.
    // @Valid annotation validates a model after binding the user input to it.
    @PostMapping(value = "/student/save")
    public int save(final @RequestBody @Valid Student student) {
        log.info("Saving student details in the database.");
        service.save(student);
        return student.getStudentId();
    }

    // Get all students from the h2 database.
    // @GetMapping annotation handles the http get request matched with the given uri.
    @GetMapping(value = "/student/getall", produces = "application/vnd.jcg.api.v1+json")
    public List<Student> getAll() {
        log.info("Getting student details from the database.");
        return service.getAll();
    }

    // FOR FORM
    @RequestMapping("/addStudent")
    public String formGet(Model model) {
        return "addOrUpdateStudent";
    }


    @PostMapping(path = "/addUpdateStudent", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseModel formPost(@RequestBody Student student, Model model) {
        model.addAttribute("student", student);
        System.out.println(student.toString());
        Student stu = service.save(student);
        ResponseModel responseModel = new ResponseModel();
        if (stu == null) {
            responseModel.setRequestCode(400);
            responseModel.setResponseMessage("Error Saving Object");
        } else {
            responseModel.setRequestCode(200);
            responseModel.setResponseMessage("Student Added Successfully");
        }
        return responseModel;
    }


    @RequestMapping("/students")
    public ModelAndView showStudents() {

        List<Student> students = service.getAll();
        System.out.println("inside cities " + students.size());
        Map<String, Object> params = new HashMap<>();

        params.put("students", students);
        System.out.println("inside cities ");

        return new ModelAndView("showStudents", params);
    }

   /* @RequestMapping("/addUpdateStudent")
    public String addStudent(Model model) {
        return "addOrUpdateStudent";
    }*/

}