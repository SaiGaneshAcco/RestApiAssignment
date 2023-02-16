package com.example.CoffeeandBrewery.service.impl;

import com.example.CoffeeandBrewery.exception.DrinkException;
import com.example.CoffeeandBrewery.model.Coffee;
import com.example.CoffeeandBrewery.repository.CoffeeRepository;
import com.example.CoffeeandBrewery.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public void saveAllRecords() {
        List<Coffee> list=new ArrayList<>();
        Coffee coffee;
        coffee = new Coffee("Latte",20.00f,50.00f,30.00f);
        list.add(coffee);
        coffee =new Coffee("Cappuccino",5.00f,35.00f,60.00f);
        list.add(coffee);
        coffee=new Coffee("Espresso",5.00f,25.00f,70.00f);
        list.add(coffee);
        coffee=new Coffee("Milk",0.00f,100.00f,0.00f);
        list.add(coffee);
        coffee=new Coffee("Water",100.00f,0.00f,0.00f);
        list.add(coffee);
        coffeeRepository.saveAll(list);
    }

    @Override
    public Coffee getDetails(String name) throws DrinkException {
        Coffee coffee;
        try {
            coffee = coffeeRepository.findByName(name);
        }
        catch (Exception e){
            throw new DrinkException("Its not an option from the menu");
        }
        if(coffee!=null)
            return coffee;
        else
            return null;
    }

    @Override
    public List<String> getMenu(){
        List<String> list=new ArrayList<>(Arrays.asList("Cappuccino","Latte","Espresso","Milk","Steam","Water"));
        return list;
    }

    @Override
    public List<Coffee> getAllDetails() {
        return coffeeRepository.findAll();
    }


}
