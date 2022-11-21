package com.simplyatul.springdatademo.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // => This class is being mapped to DB table
@Table(name = "officers") // Bec class name and table name is different 
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    /*
     * By default, enumes are saved as integer (1, 2, 3, etc)
     * So in case you add an enum in bet, then all existing values would
     * be messed up. So above annotation forces to save enums as their names
     */
    private Rank rank;
    
    @Column(nullable = false, name = "name")
    private String name;

    public Officer(Rank rank, String name) {
        super();
        this.rank = rank;
        this.name = name;
    }

}
