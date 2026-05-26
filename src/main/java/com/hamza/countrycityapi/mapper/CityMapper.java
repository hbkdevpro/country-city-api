package com.hamza.countrycityapi.mapper;

import com.hamza.countrycityapi.domain.City;
import com.hamza.countrycityapi.dto.CityResponse;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityResponse toResponse(City city) {
        return new CityResponse(
                city.getId(),
                city.getName(),
                city.getCountryId(),
                city.getPopulation(),
                city.getZipCode(),
                city.getDescription()
        );
    }
}
