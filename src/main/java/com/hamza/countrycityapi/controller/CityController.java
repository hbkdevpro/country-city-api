package com.hamza.countrycityapi.controller;

import com.hamza.countrycityapi.domain.City;
import com.hamza.countrycityapi.dto.CityResponse;
import com.hamza.countrycityapi.service.CityService;
import com.hamza.countrycityapi.mapper.CityMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
@Tag(name = "Cities", description = "City APIs")
public class CityController {

    private final CityService cityService;
    private final CityMapper cityMapper;

    @GetMapping("/{cityId}")
    @Operation(summary = "Get a city by ID")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long cityId) {
        City city = cityService.getCityById(cityId);
        return ResponseEntity.ok(cityMapper.toResponse(city));
    }
}