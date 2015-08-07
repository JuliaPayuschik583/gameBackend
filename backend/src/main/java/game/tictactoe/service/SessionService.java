package game.tictactoe.service;

import game.tictactoe.domain.Session;
import game.tictactoe.domain.User;
import game.tictactoe.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author julia
 */
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public boolean addSession(Session session) {
        Session savedSession = sessionRepository.save(session);
        return savedSession != null && savedSession.getId() != null;
    }

    public boolean setUserWinToSession(Long sessionId, User userIsWin) {
        Session session = sessionRepository.getOne(sessionId);
        if (session == null || session.getUserIsWin() != null) {
            return false;
        }
        List<User> userList = session.getUsers();
        for (User user : userList) {
            if (user != null && user.equals(userIsWin)) {
                session.setUserIsWin(userIsWin);
                sessionRepository.saveAndFlush(session);
                return true;
            }
        }
        return false;
    }
}
