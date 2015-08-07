package game.tictactoe.requests;

import game.tictactoe.domain.User;
import game.tictactoe.validate.JustTwoUsers;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author julia
 */
public class StartMatchRequest {

    @NotEmpty
    private Long sessionId;

    @JustTwoUsers
    private List<User> userList;

    public StartMatchRequest() {
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "StartMatchRequest{" +
                "sessionId=" + sessionId +
                ", userList=" + userList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StartMatchRequest that = (StartMatchRequest) o;

        return !(sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null)
                && !(userList != null ? !userList.equals(that.userList) : that.userList != null);

    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (userList != null ? userList.hashCode() : 0);
        return result;
    }
}
