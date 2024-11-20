package com.dh.DentalClinicMvc.model;

import jakarta.persistence.*;

import java.time.LocalDate;


public class Patient {


    private Integer id;
    private String name;
    private String lastname;
    private Integer cardIdentity;
    private LocalDate admissionOfDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String email;

    public Patient() {

    }

    public Patient(Integer id, String name, String lastname, Integer cardIdentity, LocalDate admissionOfDate, Address address, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.cardIdentity = cardIdentity;
        this.admissionOfDate = admissionOfDate;
        this.address = address;
        this.email = email;
    }

    public Patient(String name, String lastname, Integer cardIdentity, LocalDate admissionOfDate, Address address, String email) {
        this.name = name;
        this.lastname = lastname;
        this.cardIdentity = cardIdentity;
        this.admissionOfDate = admissionOfDate;
        this.address = address;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getCardIdentity() {
        return cardIdentity;
    }

    public void setCardIdentity(Integer cardIdentity) {
        this.cardIdentity = cardIdentity;
    }

    public LocalDate getAdmissionOfDate() {
        return admissionOfDate;
    }

    public void setAdmissionOfDate(LocalDate admissionOfDate) {
        this.admissionOfDate = admissionOfDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
