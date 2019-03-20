package by.solovei.hotel.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users", catalog = "hotel", uniqueConstraints =
        @UniqueConstraint(columnNames = "LOGIN"))
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "LOGIN", unique = true, nullable = false, length = 20)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "EMAIL", length = 20)
    private String email;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "SURNAME", length = 20)
    private String surname;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Booking> bookings = new HashSet<Booking>();

    public User() {
    }

    public User(String login, String password, String email, String name, String surname, String phone, Set<Booking> bookings) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
