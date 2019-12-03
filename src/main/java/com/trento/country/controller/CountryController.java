package com.trento.country.controller;

import com.trento.country.entities.Country;
import com.trento.country.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("{id}")
    public Country getOne(@PathVariable int id) {
        return getCountry(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        countriesList.add(country);
        return country;
    }

    @PutMapping("{id}")
    public Country update(@PathVariable int id,@RequestBody Country country) {
        Country countryFromList = getCountry(id);
        countryFromList.update(country);
        return countryFromList;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Country country = getCountry(id);
        countriesList.remove(country);
    }

    private Country getCountry(@PathVariable int id) {
        return countriesList.stream()
                .filter(country -> {
                    return country.getId() == id;
                })
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
