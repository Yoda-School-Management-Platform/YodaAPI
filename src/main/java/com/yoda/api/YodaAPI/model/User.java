package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {

    @Id
    protected long id;
    protected String[] name;

    public User() {
    }

    public long getId() {
        return id;
    }

    public String[] getName() {
        return name;
    }
}
