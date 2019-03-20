package by.solovei.hotel.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "rooms", catalog = "hotel", uniqueConstraints =
                                          @UniqueConstraint(columnNames = "Number"))
public class Room {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ROOM_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NUMBER", nullable = false, length = 10)
    private Integer number;

    @Column(name = "FLOOR", length = 10)
    private Integer floor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE_ID", nullable = false)
    private Price price;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    private Set<Booking> bookings = new HashSet<Booking>();

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Room() {
    }

    public Room(Integer number, Integer floor, Price price, String description, Set<Booking> bookings) {
        this.number = number;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", floor=" + floor +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
