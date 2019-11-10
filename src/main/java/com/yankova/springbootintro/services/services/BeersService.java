package com.yankova.springbootintro.services.services;

import com.yankova.springbootintro.services.models.BeerServiceModel;

import java.util.List;

public interface BeersService {

    List<BeerServiceModel> getBeers();

    void createBeer(String name);
}
