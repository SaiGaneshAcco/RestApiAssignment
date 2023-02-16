package com.example.CoffeeandBrewery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "brewery")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "beerQuantity")
    private long beerQuantity;

    @Column(name = "price")
    private long price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBeerQuantity() {
        return beerQuantity;
    }

    public void setBeerQuantity(long beerQuantity) {
        this.beerQuantity = beerQuantity;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Brewery() {
    }

    public Brewery(long beerQuantity, long price) {
        this.beerQuantity = beerQuantity;
        this.price = price;
    }
}

