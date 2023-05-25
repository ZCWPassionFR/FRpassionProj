package com.fairrepair.fairrepair.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Shop.
 */
@Entity
@Table(name = "shop")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Shops {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "fair_repair_rating")
    private Integer fairRepairRating;

    @Column(name = "services")
    private VehicleService services;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Shops id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Shops name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Shops phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public Shops address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFairRepairRating() {
        return this.fairRepairRating;
    }

    public Shops fairRepairRating(Integer fairRepairRating) {
        this.setFairRepairRating(fairRepairRating);
        return this;
    }

    public void setFairRepairRating(Integer fairRepairRating) {
        this.fairRepairRating = fairRepairRating;
    }

    public VehicleService getServices() {
        return this.services;
    }

    public Shops services(VehicleService services) {
        this.setServices(services);
        return this;
    }

    public void setServices(VehicleService services) {
        this.services = services;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shops)) {
            return false;
        }
        return id != null && id.equals(((Shops) o).id);
    }

    // @Override
    // public int hashCode() {
    // // see
    // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    // return
    // // getClass().hashCode();
    // }

    // prettier-ignore
    // @Override
    // public String toString() {
    // return "Shop{" +
    // "id=" + getI
    // ", name='" + getN
    // ", phoneNumber='" + getPhoneNu
    // ", address='" + getAddress() + "'" +
    // ", fairRepairRating=" + getFairRepai
    // ", services='" + getServices() + "'" +
    // "}";

    // }
}
