package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Timetable {

    @Id
    private long id;
    private String name;

    @Relationship(type = "CONTAINS", direction = Relationship.INCOMING)
    private List<TimetableEntry> entrys;

    public long getId() {
        return id;
    }

    public List<TimetableEntry> getEntrys() {
        return entrys;
    }

    public Timetable() {
    }

    public String getName() {
        return name;
    }
}
