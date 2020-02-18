package com.yoda.YodaApi.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SchoolRegisterRequest {

    @NotBlank
    @Size(min = 6, max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 50)
    private String street;

    @NotBlank
    @Size(max = 10)
    private String houseNumber;

    @NotBlank
    @Size(max = 15)
    private String zipCode;

    @NotBlank
    @Size(max = 20)
    private String city;

    @NotBlank
    @Size(max = 20)
    private String state;

    @NotBlank
    @Size(max = 20)
    private String country;

    @NotBlank
    @Size(max = 30)
    private String superuserName;

    @NotBlank
    @Size(min = 9, max = 128)
    private String superuserPassword;

    @NotBlank
    @Size(max = 50)
    private String superuserEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSuperuserName() {
        return superuserName;
    }

    public void setSuperuserName(String superuserName) {
        this.superuserName = superuserName;
    }

    public String getSuperuserPassword() {
        return superuserPassword;
    }

    public void setSuperuserPassword(String superuserPassword) {
        this.superuserPassword = superuserPassword;
    }

    public String getSuperuserEmail() {
        return superuserEmail;
    }

    public void setSuperuserEmail(String superuserEmail) {
        this.superuserEmail = superuserEmail;
    }
}
