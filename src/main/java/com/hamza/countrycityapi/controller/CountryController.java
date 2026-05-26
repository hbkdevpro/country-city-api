package com.hamza.countrycityapi.controller;


import com.hamza.countrycityapi.domain.Country;
import com.hamza.countrycityapi.domain.City;
import com.hamza.countrycityapi.dto.CountryResponse;
import com.hamza.countrycityapi.dto.CityResponse;
import com.hamza.countrycityapi.service.CountryService;
import com.hamza.countrycityapi.service.CityService;
import com.hamza.countrycityapi.mapper.CountryMapper;
import com.hamza.countrycityapi.mapper.CityMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@Tag(name = "Countries", description = "Country APIs")
public class CountryController {

    private final CountryService countryService;
    private final CityService cityService;

    private final CountryMapper countryMapper;
    private final CityMapper cityMapper;

    @GetMapping
    @Operation(summary = "Get all countries")
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();

        return ResponseEntity.ok(
                countries.stream()
                        .map(country -> countryMapper.toResponse(country))
                        .toList()
        );
    }

    @GetMapping("/{countryId}/cities")
    @Operation(summary = "Get cities by country with pagination")
    public ResponseEntity<Page<CityResponse>> getCitiesByCountry(
            @PathVariable Long countryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<City> cities = cityService.getCitiesByCountry(countryId, pageable);

        return ResponseEntity.ok(
                cities.map(city -> cityMapper.toResponse(city))
        );
    }
}