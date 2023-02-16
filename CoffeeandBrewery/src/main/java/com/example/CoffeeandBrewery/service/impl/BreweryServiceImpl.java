package com.example.CoffeeandBrewery.service.impl;

import com.example.CoffeeandBrewery.exception.DrinkException;
import com.example.CoffeeandBrewery.model.Brewery;
import com.example.CoffeeandBrewery.repository.BreweryRepository;
import com.example.CoffeeandBrewery.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BreweryServiceImpl implements BreweryService {

    @Autowired
    BreweryRepository breweryRepository;

    @Override
    public Brewery getQuantity(int amount) throws DrinkException {
        System.out.println("Amount = "+amount);
        Brewery brewery;
        try{
//            brewery=breweryRepository.findByAmount(amount);
            brewery=breweryRepository.findById(amount).get();
        }
        catch (Exception e){
            throw new DrinkException("Please enter multiples of 10 and less than 2000");
        }
        if(brewery!=null)
            return brewery;
        else
            return null;

    }

    @Override
    public List<Brewery> getAllList(){
        return breweryRepository.findAll();
    }
    @Override
    public void createList() {
        List<Brewery> list=new ArrayList<>();
        for(int i=1;i<200;i++){
            list.add(new Brewery(i*10,i));
        }
        breweryRepository.saveAll(list);
    }
}
