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

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean confirmUser(String login, String password, String email) {
        User user = userRepository.confirmUser(login, password, email);
        return user != null;
    }

    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public User editBank(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
