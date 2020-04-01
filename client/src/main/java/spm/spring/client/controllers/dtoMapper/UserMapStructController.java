package spm.spring.client.controllers.dtoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.client.dtos.UserMsDto;
import spm.spring.client.entities.User;
import spm.spring.client.entities.Views;
import spm.spring.client.exceptions.UserNotFoundException;
import spm.spring.client.repository.UserRepository;
import spm.spring.client.restservice.UserService;
import spm.spring.client.restservice.mappers.UserMapper;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    @Autowired(required=true)
    private UserRepository userRepository;

    private UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAllUserDtos(){
        return userMapper.usersToUserDtos(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public UserMsDto getUserMsDtoById(@PathVariable @Min(1) Long id) {
            return userMapper.userToUserMsDto(userRepository.findById(id).get());
    }
}
