package game.tictactoe.repository;

import game.tictactoe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author julia
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "FROM Users WHERE login = :login AND password = :password AND email = :email")
    public User confirmUser(@Param("login") String login, @Param("password") String password,
                               @Param("email") String email);

    @Query(value = "FROM Users WHERE login = :login AND password = :password")
    public User findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
