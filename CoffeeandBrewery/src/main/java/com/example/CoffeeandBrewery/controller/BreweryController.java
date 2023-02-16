package com.example.CoffeeandBrewery.controller;

import com.example.CoffeeandBrewery.exception.DrinkException;
import com.example.CoffeeandBrewery.model.Brewery;
import com.example.CoffeeandBrewery.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewery")
public class BreweryController {
    @Autowired
    BreweryService breweryService;

    @PostMapping("/createQuantityList")
    public ResponseEntity<String> createList(){
        breweryService.createList();
        return ResponseEntity.ok("Brewery quantity list is created");
    }

    @GetMapping("/getQuantity")
    public ResponseEntity<String> getQuantity(@RequestParam int amount) throws DrinkException {
        Brewery br =breweryService.getQuantity(amount);
        return ResponseEntity.ok("The quantity of beer is "+br.getBeerQuantity()+"ml for "+amount+" rupees");
    }

    @GetMapping("/allQuantities")
    public ResponseEntity<List<Brewery>> getAllQuantities(){
        return ResponseEntity.ok(breweryService.getAllList());
    }
}
