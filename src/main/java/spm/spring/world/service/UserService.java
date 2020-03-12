package spm.spring.world.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import spm.spring.world.model.ResponseModel;
import spm.spring.world.model.user.User;
import spm.spring.world.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private ResponseModel<User> userResponseModel;

    // Get all students from the h2 database.
    public ResponseModel<List<User>> getAll() {

        List<User> list = userRepository.findAll();
        return new ResponseModel<List<User>>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), list);
    }


}
