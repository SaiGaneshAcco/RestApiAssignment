package com.example.CoffeeandBrewery.repository;

import com.example.CoffeeandBrewery.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery,Integer> {

    @Query(nativeQuery = true, value = "select beer_quantity from brewery where price=?1")
    Brewery findByAmount(int amount);
}
