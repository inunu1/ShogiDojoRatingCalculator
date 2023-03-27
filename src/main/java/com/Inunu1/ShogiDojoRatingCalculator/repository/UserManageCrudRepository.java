package com.Inunu1.ShogiDojoRatingCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;


public interface UserManageCrudRepository extends JpaRepository<TtUser, Integer> {

}
