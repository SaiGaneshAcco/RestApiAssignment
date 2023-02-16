package com.example.CoffeeandBrewery.repository;

import com.example.CoffeeandBrewery.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {
    @Query(nativeQuery = true,value = "select * from coffee where coffee_name=?1")
    Coffee findByName(String name);
}
