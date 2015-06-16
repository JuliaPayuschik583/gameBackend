package game.tictactoe.domain;

import javax.persistence.*;

/**
 * @author julia
 */
@Entity
@Table(name = "Players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "idUser")//name column
    private User idUser;//FK idUser

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "idSession")//name column
    private Session idSession;//FK idSession

    @Column(name = "isWin", nullable = false)
    private boolean isWin;
}
