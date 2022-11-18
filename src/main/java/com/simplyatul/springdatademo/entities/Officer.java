package com.simplyatul.springdatademo.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "officers")
public class Officer {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(nullable = false)
    private Rank rank;
    
    @Column(nullable = false, name = "name")
    private String name;

    public Officer(Rank rank, String name) {
        super();
        this.rank = rank;
        this.name = name;
    }

}
