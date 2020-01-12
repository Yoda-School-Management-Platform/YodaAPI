package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Class {

    @Id
    private long id;
    private String name;


    public Class() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
