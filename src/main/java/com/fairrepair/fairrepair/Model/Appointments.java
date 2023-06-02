package com.fairrepair.fairrepair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Appointments")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "ApptId")
    private Long id;

    @Column(name = "ApptDayTime")
    private LocalDate date;

    // @Column(name = "ApptTime")
    // private LocalDate time;

    @Column(name = "VehicleID")
    private Integer vehicleId;

    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "ShopID")
    private Integer shopId;

    @Column(name = "ServiceID")
    private Integer serviceId;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private User user;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private VehicleService vehicleService;

    // @JsonIgnoreProperties(value = { "user", "vehicles", "appointments" },
    // allowSetters = true)
    // private User userProfile;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Appointments id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimeSlot() {
        return this.date;
    }

    public Appointments timeSlot(LocalDate timeSlot) {
        this.setTimeSlot(timeSlot);
        return this;
    }

    public void setTimeSlot(LocalDate date) {
        this.date = date;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    // public String getDay() {
    // return day;
    // }

    // public void setDay(String day) {
    // this.day = day;
    // }

    public Shop getShop() {
        return this.shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Appointments shop(Shop shop) {
        this.setShop(shop);
        return this;
    }

    public User getUserProfile() {
        return this.user;
    }

    public void setUserProfile(User user) {
        this.user = user;
    }

    public Appointments userProfile(User userProfile) {
        this.setUserProfile(userProfile);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointments)) {
            return false;
        }
        return id != null && id.equals(((Appointments) o).id);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + getId() +
                "}";
    }
}
