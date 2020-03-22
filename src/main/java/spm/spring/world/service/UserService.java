package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.entities.User;
import spm.spring.world.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //getAllUsers method
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // createUser Method
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // getUserById Method
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // getUserById Method
    public User updateUserByUserId(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // getUserById Method
    public String deleteUserByUserId(Long id) {
        String mesage = "";
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            mesage = "User deleted Successfully";
        } else {
            mesage = "User Not found";
        }
        return mesage;
    }

    // getUserById Method
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
