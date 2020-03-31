package spm.spring.world.controllers.versioning;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.dtos.UserDtoV1;
import spm.spring.world.dtos.UserDtoV2;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.restservice.UserService;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/parameterversioning/url/users")
public class UserRequestParameterVersioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // Request Parameter version - v1
    @GetMapping(value = "/{id}", params = "version=1")
    private UserDtoV1 getUserDtoByIdV1(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userService.getUserById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User Not found");
        }
        User user = optionalUser.get();
        UserDtoV1 userDtov1 = modelMapper.map(user, UserDtoV1.class);
        return userDtov1;
    }

    // Request Parameter version - v2
    @GetMapping(value = "/{id}", params = "version=2")
    private UserDtoV2 getUserDtoByIdV2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userService.getUserById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User Not found");
        }
        User user = optionalUser.get();
        UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
        return userDtoV2;
    }
}