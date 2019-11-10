package com.yankova.springbootintro.services.services.implementations;

import com.yankova.springbootintro.data.models.Beer;
import com.yankova.springbootintro.data.repositories.BeersRepository;
import com.yankova.springbootintro.services.models.BeerServiceModel;
import com.yankova.springbootintro.services.services.BeersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeersServiceImpl implements BeersService {

    private final ModelMapper mapper;
    private final BeersRepository beersRepository;

    public BeersServiceImpl(ModelMapper mapper, ModelMapper mapper1, BeersRepository beersRepository){
        this.mapper = mapper1;
        this.beersRepository = beersRepository;
    }

    @Override
    public List<BeerServiceModel> getBeers() {
        return beersRepository.findAll()
                .stream()
                .map(beer -> mapper.map(beer, BeerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createBeer(String name) {
        Beer beer = new Beer();
        beer.setName(name);
        beersRepository.saveAndFlush(beer);
}
}
