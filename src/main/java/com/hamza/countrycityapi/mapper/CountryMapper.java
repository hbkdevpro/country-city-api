package com.hamza.countrycityapi.mapper;

import com.hamza.countrycityapi.domain.Country;
import com.hamza.countrycityapi.dto.CountryResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryResponse toResponse(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getName()
        );
    }

}
