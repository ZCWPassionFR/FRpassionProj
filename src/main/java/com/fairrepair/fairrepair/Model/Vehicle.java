package com.fairrepair.fairrepair.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Vehicle.
 */
@Entity
@Table(name = "Vehicles")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "VehicleID")
    private Long id;

    @Column(name = "VehicleYear")
    private Integer year;

    @Column(name = "Make")
    private String make;

    @Column(name = "Model")
    private String model;

    @Column(name = "Engine")
    private String engine;

    @Column(name = "Color")
    private String color;

    @Column(name = "Mileage")
    private Integer mileage;

    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "VehicleImage")
    private String vehicleImage;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    @JsonIgnoreProperties(value = { "shop", "userProfile" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Appointments appointment;

    @ManyToOne
    @JsonIgnoreProperties(value = { "user", "vehicles", "appointments" }, allowSetters = true)
    private User userProfile;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Vehicle id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public Vehicle make(String make) {
        this.setMake(make);
        return this;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public Vehicle model(String model) {
        this.setModel(model);
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vehicle mileage(Integer mileage) {
        this.setMileage(mileage);
        return this;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    private String getMileage() {
        return null;
    }

    public Integer getVehicleYear() {
        return this.year;
    }

    public Vehicle vehicleYear(Integer vehicleYear) {
        this.setVehicleYear(vehicleYear);
        return this;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.year = vehicleYear;
    }

    public Appointments getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Appointments appointment) {
        this.appointment = appointment;
    }

    public Vehicle appointment(Appointments appointment) {
        this.setAppointment(appointment);
        return this;
    }

    public User getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }

    public Vehicle userProfile(User userProfile) {
        this.setUserProfile(userProfile);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        return id != null && id.equals(((Vehicle) o).id);
    }

    @Override
    public int hashCode() {
        // see
        // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + getId() +
                ", make='" + getMake() + "'" +
                ", model='" + getModel() + "'" +
                ", mileage=" + getMileage() +
                ", vehicleYear=" + getVehicleYear() +
                "}";
    }

}
