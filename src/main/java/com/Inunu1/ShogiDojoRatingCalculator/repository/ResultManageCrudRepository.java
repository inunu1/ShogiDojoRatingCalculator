package com.Inunu1.ShogiDojoRatingCalculator.repository;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ResultManageCrudRepository extends JpaRepository<TtGameResult, Integer> {
    @Query(value = "SELECT " +
            " tgr.game_date,tuw.user_name AS \"winner_name\"" +
            ",tul.user_name AS \"loser_name\" " +
            "FROM `tt_game_result` tgr " +
            "INNER JOIN tt_user tuw ON tgr.winner_id = tuw.user_id " +
            "INNER JOIN tt_user tul ON tgr.loser_id = tul.user_id"
    ,nativeQuery = true)
    List<Object[]> getResult();
}
