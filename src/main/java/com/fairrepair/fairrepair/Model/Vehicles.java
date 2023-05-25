package com.fairrepair.fairrepair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Vehicle.
 */
@Entity
@Table(name = "vehicle")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "vehicle_year")
    private Integer vehicleYear;

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

    public Vehicles id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public Vehicles make(String make) {
        this.setMake(make);
        return this;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public Vehicles model(String model) {
        this.setModel(model);
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public Vehicles licenseNumber(String licenseNumber) {
        this.setLicenseNumber(licenseNumber);
        return this;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Integer getMileage() {
        return this.mileage;
    }

    public Vehicles mileage(Integer mileage) {
        this.setMileage(mileage);
        return this;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getVehicleYear() {
        return this.vehicleYear;
    }

    public Vehicles vehicleYear(Integer vehicleYear) {
        this.setVehicleYear(vehicleYear);
        return this;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public Appointments getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Appointments appointment) {
        this.appointment = appointment;
    }

    public Vehicles appointment(Appointments appointment) {
        this.setAppointment(appointment);
        return this;
    }

    public User getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }

    public Vehicles userProfile(User userProfile) {
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
        if (!(o instanceof Vehicles)) {
            return false;
        }
        return id != null && id.equals(((Vehicles) o).id);
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
                ", licenseNumber='" + getLicenseNumber() + "'" +
                ", mileage=" + getMileage() +
                ", vehicleYear=" + getVehicleYear() +
                "}";
    }
}
