package game.tictactoe.repository;

import game.tictactoe.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author julia
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
