package game.tictactoe.service;

import game.tictactoe.domain.User;
import game.tictactoe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author julia
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser != null && savedUser.getId() != null;
    }

    public boolean confirmUser(String login, String password, String email) {
        User user = userRepository.confirmUser(login, password, email);
        return user != null;
    }

    public boolean findByLoginAndPassword(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        return user != null;
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
