package com.yankova.springbootintro.web.controllers;

import com.yankova.springbootintro.services.models.BeerServiceModel;
import com.yankova.springbootintro.services.services.BeersService;
import com.yankova.springbootintro.web.models.BeerViewModel;
import com.yankova.springbootintro.web.models.CreateBeerViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BeersController {
    private final BeersService beersService;
    private final ModelMapper mapper;

    public BeersController(BeersService beersService, ModelMapper mapper) {
        this.beersService = beersService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public ModelAndView getAllBeers(ModelAndView modelAndView) {
        modelAndView.addObject("text", "Hello from modelAndView");
        List<BeerViewModel> beers = beersService.getBeers()
                .stream()
                .map(beer -> mapper.map(beer, BeerViewModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("beers", beers);
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/{beerName}")
    public ModelAndView getBeerDetails(@PathVariable("beerName") String beerName, ModelAndView modelAndView) {
        modelAndView.addObject("beer", beerName);
        modelAndView.setViewName("details.html");
        return modelAndView;
    }

    @PostMapping("/")
    public String createBeer(@ModelAttribute CreateBeerViewModel model) {
        beersService.createBeer(model.getName());
        return "redirect:/";
    }
}
