package com.trento.country.controller;

import com.trento.country.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("country")
public class CountryController {

    private List<Map<String, String>> countries = new ArrayList<Map<String, String>>() {
        {
            add(new HashMap<>(){{
                put("id", "1");
                put("country", "Greece");
                put("capital", "Athens");
            }});
            add(new HashMap<>(){{
                put("id", "2");
                put("country", "France");
                put("capital", "Paris");
            }});
            add(new HashMap<>(){{
                put("id", "2");
                put("country", "Italy");
                put("capital", "Rome");
            }});
        }
    };

    @GetMapping
    public List<Map<String, String>> listCountries() {
        return countries;
    }

    @GetMapping("{id}")
    public Map<String, String> getCountry(@PathVariable String id) {
        Map<String, String> mapCountries = countries.stream()
                .filter(country -> country.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        return mapCountries;
    }
}
