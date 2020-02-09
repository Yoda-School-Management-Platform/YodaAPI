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
    private String superuser_name;

    @NotBlank
    @Size(max = 64)
    private String superuser_password;

    @NotBlank
    @Size(max = 50)
    private String superuser_email;

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

    public String getSuperuser_name() {
        return superuser_name;
    }

    public void setSuperuser_name(String superuser_name) {
        this.superuser_name = superuser_name;
    }

    public String getSuperuser_password() {
        return superuser_password;
    }

    public void setSuperuser_password(String superuser_password) {
        this.superuser_password = superuser_password;
    }

    public String getSuperuser_email() {
        return superuser_email;
    }

    public void setSuperuser_email(String superuser_email) {
        this.superuser_email = superuser_email;
    }
}
