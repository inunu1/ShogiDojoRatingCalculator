package com.Inunu1.ShogiDojoRatingCalculator.repository;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultCrudRepository extends JpaRepository<TtGameResult, Integer> {

}
