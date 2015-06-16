package game.tictactoe.repository;

import game.tictactoe.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author julia
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
}
