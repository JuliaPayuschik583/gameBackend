package game.tictactoe.controllers;

import game.tictactoe.domain.User;
import game.tictactoe.service.UserService;
import game.tictactoe.validate.Email;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.FormParam;

/**
 * @author julia
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody User test(@RequestBody User user) {
        //model.addAttribute("name", name);
        User user1 = new User();
        user1.setId(1L);
        user1.setLogin("Admin");
        user1.setPassword("123J");
        return user1;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody Boolean registration(@NotEmpty @FormParam("login") String login,
                                @NotEmpty @FormParam("password") String password,
                                @Email(canBeNullOrEmpty = true) @FormParam("email") String email) {
        logger.debug("method registration with params login = " + login
                + ", password = " + password + ", email = " + email);
        return !userService.confirmUser(login, password, email)
                && userService.addUser(new User(login, password, email));
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody Boolean authUser(@NotEmpty @FormParam("login") String login,
                            @NotEmpty @FormParam("password") String password) {
        logger.debug("method authUser with params login = " + login + ", password = " + password);
        return userService.authUser(login, password);
    }


}
