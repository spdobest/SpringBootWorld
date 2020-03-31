package spm.spring.world.controllers.dtosmapStruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.dtos.UserMsDto;
import spm.spring.world.repository.UserRepository;
import spm.spring.world.restservice.mappers.UserMapper;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
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
