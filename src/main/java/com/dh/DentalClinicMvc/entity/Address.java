package com.dh.DentalClinicMvc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Adressse")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private Integer number;
    @Column(name = "location")
    private String location;
    @Column(name = "province")
    private String province;

    public Address() {
    }

    public Address(Long id, String street, Integer number, String location, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
