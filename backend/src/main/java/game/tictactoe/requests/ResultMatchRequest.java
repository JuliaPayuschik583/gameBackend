package game.tictactoe.requests;

import game.tictactoe.domain.User;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author julia
 */
public class ResultMatchRequest {

    @NotEmpty
    private Long sessionId;

    @NotEmpty
    private User userIsWin;

    public ResultMatchRequest() {
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUserIsWin() {
        return userIsWin;
    }

    public void setUserIsWin(User userIsWin) {
        this.userIsWin = userIsWin;
    }

    @Override
    public String toString() {
        return "ResultMatchRequest{" +
                "sessionId=" + sessionId +
                ", userIsWin=" + userIsWin +
                '}';
    }
}
