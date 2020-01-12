package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class TimetableEntry {

    @Id
    private long id;
    private String type;
    private String text;

    public TimetableEntry() {
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
