package com.api.fleetmanagement.repository;

import com.api.fleetmanagement.models.TaxisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxisRepository extends JpaRepository<TaxisModel, Integer> {
}
