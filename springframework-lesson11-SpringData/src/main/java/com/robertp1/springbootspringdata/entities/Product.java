package com.robertp1.springbootspringdata.entities;

import jakarta.persistence.*;

@Entity                     // The @Entity annotation is telling JPA that this class is mapping the table in the database.
@Table(name = "product")    // The @Table annotation is only needed if the name of the class is not the same as the name of the table in the database.
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY      // This strategy means that the database will create the generator and increment the id.
    )
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
