package com.hamza.countrycityapi.dto;

public record CityResponse(
        Long id,
        String name,
        Long countryId,
        int population,
        String zipCode,
        String description
) {}