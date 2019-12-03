package com.trento.country.controller;

import com.trento.country.entities.Country;
import com.trento.country.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("country")
public class CountryController {

    private List<Country> countriesList = new ArrayList<>(){{
        add(new Country("Greece", "Athens"));
        add(new Country("France", "Paris"));
        add(new Country("Italy", "Rome"));
    }};

    @GetMapping
    public List<Country> listCountries() {
        return countriesList;
    }

    @GetMapping("/{id}")
    public Country getCountryList(@PathVariable String id) {

        Country outCountry = countriesList.stream()
                .filter(country -> {
                    System.out.println("Country id: " + country.getId());
                    int idInt = Integer. parseInt(id);
                    return country.getId() == idInt;
                })
                .findFirst()
                .orElseThrow(NotFoundException::new);
        return outCountry;
    }
}
