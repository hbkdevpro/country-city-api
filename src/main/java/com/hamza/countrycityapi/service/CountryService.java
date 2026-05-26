package com.hamza.countrycityapi.service;

import com.hamza.countrycityapi.domain.Country;
import java.util.List;

public class CountryService {

    private static final List<Country> COUNTRIES = List.of(
            new Country(1L, "Spain"),
            new Country(2L, "India"),
            new Country(3L, "Luxembourg")
    );

    public List<Country> getAllCountries() {
        return COUNTRIES;
    }

    public Country getCountryById(Long id) {
        return COUNTRIES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
