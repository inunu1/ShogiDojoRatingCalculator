package com.Inunu1.ShogiDojoRatingCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;

import java.util.List;


public interface UserManageCrudRepository extends JpaRepository<TtUser, Integer> {
    List<TtUser> findByNameContaining(String name);
    List<TtUser> findByIdIn(List<Integer> Ids);
}
