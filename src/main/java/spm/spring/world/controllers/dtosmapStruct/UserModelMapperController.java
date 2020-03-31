package spm.spring.world.controllers.dtosmapStruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.dtos.UserMmDto;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.restservice.UserService;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    private UserMmDto getUserDtoById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userService.getUserById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User Not found");
        }
        User user = optionalUser.get();
        UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
        return userMmDto;
    }
}
