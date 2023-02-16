package com.example.CoffeeandBrewery.service;

import com.example.CoffeeandBrewery.exception.DrinkException;
import com.example.CoffeeandBrewery.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CoffeeService {

    void saveAllRecords();

    Coffee getDetails(String name) throws DrinkException;

    List<String> getMenu();

    List<Coffee> getAllDetails();
}
