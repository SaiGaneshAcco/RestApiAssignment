package com.example.CoffeeandBrewery.service;

import com.example.CoffeeandBrewery.exception.DrinkException;
import com.example.CoffeeandBrewery.model.Brewery;

import java.util.List;

public interface BreweryService {
    Brewery getQuantity(int amount) throws DrinkException;

    List<Brewery> getAllList();

    void createList();
}
