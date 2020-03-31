package spm.spring.world.controllers.dtosmapStruct;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.restservice.UserService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/jacksonfilter/users")
public class UserMappingJacksonController {

    @Autowired
    private UserService userService;

    // create user method
    // @PathVariable Annotation
    // @GetMapping Annotation
    @GetMapping("/{id}")
    public MappingJacksonValue getUserById(@PathVariable Long id) {
        try {
            Optional<User> userOptional = userService.getUserById(id);
            User user = userOptional.get();

            Set<String> fields = new HashSet<>();
            fields.add("userId");
            fields.add("firstName");
            fields.add("lastName");
            fields.add("ssn");
            fields.add("orders");
            MappingJacksonValue mapper = new MappingJacksonValue(user);
            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            mapper.setFilters(filterProvider);

            return mapper;
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // getUserById - fields with @RequestParam
    @GetMapping("/params/{id}")
    public MappingJacksonValue getUserById2(@PathVariable Long id,
                                            @RequestParam Set<String> fields) {
        try {
            Optional<User> userOptional = userService.getUserById(id);
            User user = userOptional.get();

            MappingJacksonValue mapper = new MappingJacksonValue(user);
            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            mapper.setFilters(filterProvider);

            return mapper;
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
