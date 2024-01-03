package com.api.fleetmanagement.repository;

import com.api.fleetmanagement.models.TrajectoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<TrajectoriesModel, Integer> {

    @Query(value = "SELECT t FROM TrajectoriesModel t LEFT JOIN FETCH t.taxi tx WHERE t.taxi.id = ?1")
    List<TrajectoriesModel> findTrajectoriesByTaxiId(Integer taxiId);
}
