package com.api.fleetmanagement.repository;

import com.api.fleetmanagement.models.TaxisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxisRepository extends JpaRepository<TaxisModel, Integer> {

    @Query("SELECT t FROM TaxisModel t WHERE t.id = :taxiId")
    TaxisModel findTaxiById(@Param("taxiId") String taxiId);
}
