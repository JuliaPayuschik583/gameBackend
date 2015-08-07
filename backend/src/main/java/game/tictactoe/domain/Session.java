package game.tictactoe.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author julia
 */
@Entity
@Table(name = "Sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idSession")
    private List<Player> players;//players of this session
}
