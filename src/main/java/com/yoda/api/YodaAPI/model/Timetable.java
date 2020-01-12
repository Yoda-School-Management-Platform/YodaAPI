package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Timetable {

    @Id
    private long id;
    private String name;

    public Timetable() {
    }

    public String getName() {
        return name;
    }
}
