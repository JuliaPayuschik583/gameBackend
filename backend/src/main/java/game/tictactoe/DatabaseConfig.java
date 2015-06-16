package game.tictactoe;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author julia
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("game.tictactoe.repository")
@EntityScan("game.tictactoe.domain")
public class DatabaseConfig {
}
