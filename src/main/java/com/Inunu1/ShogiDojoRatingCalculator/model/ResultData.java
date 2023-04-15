package com.Inunu1.ShogiDojoRatingCalculator.model;

import lombok.Data;

@Data
public class ResultData {
    private String 	game_date;
    private Integer winnerId;
    private Integer loserId;
    private Integer floating_rate;
    private String sync_flg;
    private String update_date;
}
