package game.tictactoe.controllers;

import game.tictactoe.domain.User;
import game.tictactoe.service.UserService;
import game.tictactoe.validate.Email;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.ws.rs.FormParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author julia
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody List<User> test() {//(@RequestBody User user) {
        //model.addAttribute("name", name);
        User user1 = new User();
        user1.setId(1L);
        user1.setLogin("Admin");
        user1.setPassword("123J");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user1);
        return userList;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody Boolean registration(@Valid Registrater registrater) {
        logger.debug("method registration with params login = " + registrater.getLogin()
                + ", password = " + registrater.getPassword() + ", email = " + registrater.getEmail());
        return !userService.findByLoginAndPassword(registrater.getLogin(), registrater.getPassword())
                && userService.addUser(new User(registrater.getLogin(), registrater.getPassword(), registrater.getEmail()));
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody Boolean authUser(@Valid Auther auther) {
        logger.debug("method authUser with params login = " + auther.getLogin() + ", password = " + auther.getPassword());
        return userService.findByLoginAndPassword(auther.getLogin(), auther.getPassword());
    }

    static class Registrater {
        @NotEmpty String login;
        @NotEmpty String password;
        @Email(canBeNullOrEmpty = true) String email;

        public Registrater() {
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    static class Auther {
        @NotEmpty String login;
        @NotEmpty String password;

        public Auther() {
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
