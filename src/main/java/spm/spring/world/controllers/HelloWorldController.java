package spm.spring.world.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.models.UserDetails;

@RestController
public class HelloWorldController {

    //  simple method
    // URI - /helloworld
    // GET
    // RequestMapping( method = "RequestMethod.GET" , path = "/helloworld")
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "helloworld";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails getUserDetails(){
        return new UserDetails("Siba","Mohanty","dublin");
    }
}
