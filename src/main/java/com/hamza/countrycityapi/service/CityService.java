package com.hamza.countrycityapi.service;

import com.hamza.countrycityapi.domain.City;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {

    private static final List<City> CITIES = List.of(
            new City(1L, "Madrid", 1L, 3280000, "28000", "Capital of Spain"),
            new City(2L, "Barcelona", 1L, 1600000, "08000", "Major city in Spain"),

            new City(3L, "New Delhi", 2L, 16787941, "110001", "Capital of India"),
            new City(4L, "Mumbai", 2L, 12442373, "400001", "Financial center of India"),

            new City(5L, "Luxembourg City", 3L, 128512, "1009", "Capital of Luxembourg"),
            new City(6L, "Esch-sur-Alzette", 3L, 36000, "4001", "Second largest city in Luxembourg")
    );

    public Page<City> getCitiesByCountry(Long countryId, Pageable pageable) {
        List<City> filtered = CITIES.stream()
                .filter(c -> c.getCountryId().equals(countryId))
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), filtered.size());

        List<City> paged = filtered.subList(start, end);

        return new PageImpl<>(paged, pageable, filtered.size());
    }

    public City getCityById(Long id) {
        return CITIES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}