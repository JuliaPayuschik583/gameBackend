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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author julia
 */
@Controller
public class SessionController {

    private static final Logger logger = Logger.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/startMatch", method = RequestMethod.POST)
    public @ResponseBody Boolean startMatch(@Valid @RequestBody Starter starter) {
        logger.debug("method startMatch with params userList = " + starter.getUserList());
        Session session = new Session();
        session.setDate(new Date());
        session.setUsers(starter.getUserList());
        return sessionService.addSession(session);
    }

    @RequestMapping(value = "/resultMatch", method = RequestMethod.POST)
    public @ResponseBody Boolean resultMatch(@Valid @RequestBody Result result) {
        logger.debug("method startMatch with params resultMatchRequest = " + result.getResultMatchRequest());
        return sessionService.setUserWinToSession(result.getResultMatchRequest().getSessionId(),
                result.getResultMatchRequest().getUserIsWin());
    }

    static class Starter {
        @JustTwoUsers
        private List<User> userList;

        public Starter() {
        }

        public List<User> getUserList() {
            return userList;
        }

        public void setUserList(List<User> userList) {
            this.userList = userList;
        }
    }

    static class Result {
        @NotEmpty ResultMatchRequest resultMatchRequest;

        public Result() {
        }

        public ResultMatchRequest getResultMatchRequest() {
            return resultMatchRequest;
        }

        public void setResultMatchRequest(ResultMatchRequest resultMatchRequest) {
            this.resultMatchRequest = resultMatchRequest;
        }
    }
}
