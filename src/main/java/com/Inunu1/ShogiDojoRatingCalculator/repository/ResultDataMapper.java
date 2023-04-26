package com.Inunu1.ShogiDojoRatingCalculator.repository;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ResultDataMapper {

    @Mapping(source = "game_date", target="game_date")
    @Mapping(source = "winner", target="winner")
    @Mapping(source = "loser", target="loser")
    ResultData toDTO(String game_date, String winner, String loser);
}
