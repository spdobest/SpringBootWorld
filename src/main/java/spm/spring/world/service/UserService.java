package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.entities.User;
import spm.spring.world.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //getAllUsers method
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
