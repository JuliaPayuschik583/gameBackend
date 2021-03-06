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
    @Column(name = "session_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "sessions")
    private List<User> users;//users of this session

    @OneToOne
    @JoinColumn(name = "user_is_win", nullable = true)
    private User userIsWin;//id of user

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserIsWin() {
        return userIsWin;
    }

    public void setUserIsWin(User userIsWin) {
        this.userIsWin = userIsWin;
    }
}
