package spm.spring.client.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.client.entities.User;
import spm.spring.client.entities.Views;
import spm.spring.client.exceptions.UserExistsException;
import spm.spring.client.exceptions.UserNameNotFoundException;
import spm.spring.client.exceptions.UserNotFoundException;
import spm.spring.client.repository.UserRepository;
import spm.spring.client.restservice.UserService;

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
    public User createUser(User user) throws UserExistsException {
        Optional<User> userCreate = userRepository.findById(user.getUserId());
        if (userCreate.isPresent()) {
            throw new UserExistsException("User already exist, please check the user id");
        }
        return userRepository.save(user);
    }

    // getUserById Method
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User Not found in Repository");
        }
        return user;
    }

    // getUserById Method
    public User updateUserByUserId(Long id, User user) throws UserNotFoundException {
        Optional<User> updatedUer = userRepository.findById(id);
        if (!updatedUer.isPresent()) {
            throw new UserNotFoundException("User Not found in Repository,Please provide correct user Id");
        }
        user.setUserId(id);
        return userRepository.save(user);
    }

    // getUserById Method
    public String deleteUserByUserId(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return "User deleted Successfully";
        } else {
            throw new UserNotFoundException("User Not Found, Please provide correct user id to delete");
        }
    }

    // getUserById Method
    public User getUserByUserName(String userName) throws UserNameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            return userRepository.findByUserName(userName);
        } else {
            throw new UserNameNotFoundException("Username " + userName + " not found in the user repository");
        }

    }
}
