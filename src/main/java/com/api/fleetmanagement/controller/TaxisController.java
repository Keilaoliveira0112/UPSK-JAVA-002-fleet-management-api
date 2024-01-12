package com.api.fleetmanagement.controller;

import com.api.fleetmanagement.models.TaxisModel;
import com.api.fleetmanagement.models.TrajectoriesModel;
import com.api.fleetmanagement.repository.TaxisRepository;
import com.api.fleetmanagement.repository.TrajectoriesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;

@RestController
public class TaxisController {


    @Autowired
    TaxisRepository taxisRepository;

    @Autowired
    TrajectoriesRepository trajectoriesRepository;


    @Operation(summary = "Get all taxis from database")
    @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Found the taxi",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaxisModel.class)) }),
            })
    @GetMapping("/taxis")
    public ResponseEntity<Page<TaxisModel>> getAllTaxis(@PageableDefault(size=10, sort = {"id"}) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(taxisRepository.findAll(pageable));
    }


    @Operation(summary = "Get all trajectories by taxi id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrajectoriesModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxi not found",
                    content = @Content) })

    @GetMapping("/taxis/{id}")
    public ResponseEntity<Page<TrajectoriesModel>> getTaxiById(@PathVariable Integer id, Pageable pageable) {
        Optional<TaxisModel> taxi = taxisRepository.findById(id);

        if (taxi.isPresent()) {
            Page<TrajectoriesModel> trajectoryInfoList = trajectoriesRepository.findTrajectoriesByTaxiId(Integer.toString(id), pageable);

            return ResponseEntity.status(HttpStatus.OK).body(trajectoryInfoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Get a taxis last trajectory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found last trajectories taxi",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrajectoriesModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxi not found",
                    content = @Content)})
    @GetMapping("/taxis/last-locations")
    public ResponseEntity<Page<TrajectoriesModel>> getTaxiLastLocations(Pageable pageable) {
        Page<TrajectoriesModel> trajectoryLastLocations = trajectoriesRepository.findLastLocations(pageable);
        return ResponseEntity.ok(trajectoryLastLocations);
    }

}