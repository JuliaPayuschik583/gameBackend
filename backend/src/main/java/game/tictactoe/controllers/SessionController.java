package game.tictactoe.controllers;

import game.tictactoe.domain.Session;
import game.tictactoe.domain.User;
import game.tictactoe.requests.ResultMatchRequest;
import game.tictactoe.service.SessionService;
import game.tictactoe.validate.JustTwoUsers;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author julia
 */
@Controller
public class SessionController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/startMatch", method = RequestMethod.POST)
    public @ResponseBody Boolean startMatch(@JustTwoUsers @RequestBody List<User> userList) {
        logger.debug("method startMatch with params userList = " + userList);
        Session session = new Session();
        session.setUsers(userList);
        return sessionService.addSession(session);
    }

    @RequestMapping(value = "/resultMatch", method = RequestMethod.POST)
    public @ResponseBody Boolean resultMatch(@RequestBody @NotEmpty ResultMatchRequest resultMatchRequest) {
        logger.debug("method startMatch with params resultMatchRequest = " + resultMatchRequest);
        return sessionService.setUserWinToSession(resultMatchRequest.getSessionId(),
                resultMatchRequest.getUserIsWin());
    }
}
