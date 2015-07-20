package game.tictactoe.controllers;

import game.tictactoe.domain.User;
import game.tictactoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author julia
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
    public String registration(@RequestParam("login") String login, @RequestParam("password") String password,
                               @RequestParam("email") String email) {
        if(!userService.confirmUser(login, password, email)) {
            userService.addUser(new User(login, password, email));
        }
        return null;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = userService.findByLoginAndPassword(login, password);
        return null;
    }


}
