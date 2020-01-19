package com.yoda.api.YodaAPI.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@NodeEntity("School")
public class School {

        @Id @GeneratedValue private Long id;

        @Property("name")
        private String name;

        @Property("password")
        private String password;

        @CreatedDate
        private LocalDate createdAt;

        @LastModifiedDate
        private LocalDate updatedAt;

        public LocalDate getCreatedAt() {
                return createdAt;
        }

        public LocalDate getUpdatedAt() {
                return updatedAt;
        }

        public void setName(String name) {
                this.name = name;
        }

        public School() {
        }

        public School(String name, String password) {
                this.name = name;
                this.password = password;
        }

        public String getPassword() {
                return password;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

}