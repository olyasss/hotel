package by.solovei.hotel.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "price", catalog = "hotel")
public class Price implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "TYPE_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "TYPE_ROOM", nullable = false, length = 50)
    private String typeRoom;

    @Column(name = "COST", length = 10)
    private Integer cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "price")
    private Set<Room> rooms = new HashSet<Room>();

    public Price() {
    }

    public Price(String typeRoom, Integer cost, Set<Room> rooms) {
        this.typeRoom = typeRoom;
        this.cost = cost;
        this.rooms = rooms;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", typeRoom='" + typeRoom + '\'' +
                ", cost=" + cost +
                '}';
    }
}
