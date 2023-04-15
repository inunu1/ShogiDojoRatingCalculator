package com.Inunu1.ShogiDojoRatingCalculator.repository;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultManageCrudRepository extends JpaRepository<TtGameResult, Integer> {

}
