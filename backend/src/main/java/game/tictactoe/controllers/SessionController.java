package game.tictactoe.controllers;

import game.tictactoe.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author julia
 */
@Controller
public class SessionController {

    @RequestMapping(value = "/startMatch", produces="application/json", method = RequestMethod.POST)
    public String startMatch(int sessionId, List<User> userList) {
        return null;
    }

    @RequestMapping(value = "/resultMatch", produces="application/json", method = RequestMethod.POST)
    public String resultMatch(int sessionId, Map<User, Boolean> userMap) {
        return null;
    }
}
