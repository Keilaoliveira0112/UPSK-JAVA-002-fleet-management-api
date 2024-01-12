package com.api.fleetmanagement.repository;

import com.api.fleetmanagement.models.TrajectoriesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface TrajectoriesRepository extends JpaRepository<TrajectoriesModel, Integer> {

    @Query(value = "FROM TrajectoriesModel t WHERE t.taxi.id = :taxiId")
    Page<TrajectoriesModel> findTrajectoriesByTaxiId(@Param("taxiId") String taxiId, Pageable pageable);

    @Query("SELECT t FROM TrajectoriesModel t " + "JOIN t.taxi tr " + "WHERE t.id IN (SELECT MAX(tt.id) " +
            "FROM TrajectoriesModel tt GROUP BY tt.taxi) " + "ORDER BY t.date DESC")
    Page<TrajectoriesModel> findLastLocations(Pageable pageable);
}



