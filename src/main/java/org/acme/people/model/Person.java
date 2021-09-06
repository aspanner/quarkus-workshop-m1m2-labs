package org.acme.people.model;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.vertx.axle.core.eventbus.EventBus;
import io.vertx.axle.core.eventbus.Message;



@Entity
public class Person extends PanacheEntity {
    
 
    public String name;

    // the person's birthdate
    public LocalDate birth;

    // the person's eye color
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    public EyeColor eyes;

    public static List<Person> findByColor(EyeColor color) {
        return list("eyes", color);
    }

    public static List<Person> getBeforeYear(int year) {
        return Person.<Person>streamAll()
        .filter(p -> p.birth.getYear() <= year)
        .collect(Collectors.toList());
    }

   
}