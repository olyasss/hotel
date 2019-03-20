package by.solovei.hotel.models;

import javax.persistence.*;
import java.sql.Date;

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
    private Date dateFrom;

    @Column(name = "DATE_TO", nullable = false)
    private Date dateTo;

    @Column(name = "PASSPORT", nullable = false, length = 20)
    private Integer passport;

    @Column(name = "IS_PAID", nullable = false, length = 20)
    private String paid;

    public Booking() {
    }

    public Booking(User user, Room room, Date dateFrom, Date dateTo,
                   Integer passport, String paid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        passport = passport;
        this.paid = paid;
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

    public Integer getPassport() {
        return passport;
    }

    public void setPassport(Integer passport) {
        passport = passport;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
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
                ", paid=" + paid +
                '}';
    }
}
