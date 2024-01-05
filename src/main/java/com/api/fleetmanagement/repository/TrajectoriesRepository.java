package com.api.fleetmanagement.repository;

import com.api.fleetmanagement.models.TrajectoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<TrajectoriesModel, Integer> {

    @Query(value = "FROM TrajectoriesModel t WHERE t.taxi.id = :taxiId")
    List<TrajectoriesModel> findTrajectoriesByTaxiId(@Param("taxiId") String taxiId);
}
