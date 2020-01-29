package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class User {

    @Id @GeneratedValue
    private long id;

    @Property("username")
    private String username;

    @Property("password")
    private String password;

    @Property("role")
    private String role;

    @Property("enabled")
    private boolean enabled;

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
