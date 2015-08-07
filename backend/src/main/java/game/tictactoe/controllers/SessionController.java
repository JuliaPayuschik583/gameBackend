package game.tictactoe.controllers;

import game.tictactoe.domain.User;
import game.tictactoe.requests.StartMatchRequest;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import java.util.Map;

/**
 * @author julia
 */
@Controller
public class SessionController {

    @RequestMapping(value = "/startMatch", method = RequestMethod.POST)
    public String startMatch(@RequestBody @NotNull StartMatchRequest startMatchRequest) {

        return null;
    }

    @RequestMapping(value = "/resultMatch", method = RequestMethod.POST)
    public String resultMatch(@NotEmpty @FormParam("sessionId") Long sessionId, @RequestBody Map<User, Boolean> userMap) {
        return null;
    }
}
