package com.api.fleetmanagement.controller;

import com.api.fleetmanagement.models.TaxisModel;
import com.api.fleetmanagement.repository.TaxisRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;



import java.util.List;

@RestController
public class TaxisController {
    @Autowired
    TaxisRepository taxisRepository;

    @Operation(summary = "Get all taxis from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaxisModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxis not found",
                    content = @Content) })
    @GetMapping("/taxis")
    public ResponseEntity<Page<TaxisModel>> getAllTaxis(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(taxisRepository.findAll(pageable));
    }

}
