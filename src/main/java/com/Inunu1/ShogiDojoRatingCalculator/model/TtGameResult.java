package com.Inunu1.ShogiDojoRatingCalculator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tt_game_result")
public class TtGameResult {
	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gameId;

	@Column(name = "game_date")
	private String gameDate;
	
	@Column(name = "winner_id")
	private Integer winnerId;

	@Column(name = "loser_id")
	private Integer loserId;

	@Column(name = "floating_rate")
	private Integer floatingRate;
	
	@Column(name = "sync_flg")
	private String syncFlg;
	
	@Column(name = "update_date")
	private String updateDate;

}