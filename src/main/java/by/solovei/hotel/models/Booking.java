package by.solovei.hotel.models;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "booking", catalog = "hotel")
public class Booking {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "BOOK_ID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

    @Column(name = "DATE_FROM", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "DATE_TO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @Column(name = "PASSPORT", nullable = false, length = 30)
    private String passport;

    public Booking() {
    }

    public Booking(User user, Room room, Date dateFrom, Date dateTo,
                   String passport) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", passport=" + passport +
                '}';
    }
}
