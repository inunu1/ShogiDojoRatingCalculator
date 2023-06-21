package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;
import com.Inunu1.ShogiDojoRatingCalculator.repository.UserManageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CalcRateService {
	@Autowired
	private UserManageCrudRepository userManageCrudRepository;
	private static final Integer K_FACTOR = 32;
	private static final Integer RESULT_WIN = 1;
	private static final Integer RESULT_LOSE = 0;

	public void calcRate(Integer winnerId, Integer loserId) {

		// 1.勝者、敗者のユーザー情報を取得
		List<Integer> userIds = new ArrayList<>();
		userIds.add(winnerId);
		userIds.add(loserId);
		List<TtUser> ttUsers = userManageCrudRepository.findByIdIn(userIds);

		Map<Integer, TtUser> ttUserMap = ttUsers.stream().collect(Collectors.toMap(TtUser::getId, u -> u));
		TtUser winner = ttUserMap.get(winnerId);
		TtUser loser = ttUserMap.get(loserId);

		// 2.レーティング計算を実施
		int beforeRateWinner = winner.getRate();
		int beforeRateLoser = loser.getRate();

		double expectedScoreWinner = getExpectedScore(beforeRateWinner, beforeRateLoser);
		double expectedScoreLoser = getExpectedScore(beforeRateLoser, beforeRateWinner);

		int afterRateWinner = updateRating(beforeRateWinner, expectedScoreWinner, K_FACTOR, RESULT_WIN);
		int afterRateLoser = updateRating(beforeRateLoser, expectedScoreLoser, K_FACTOR, RESULT_LOSE);

		// 3.レーティング計算結果をDBに反映
		winner.setRate(afterRateWinner);
		loser.setRate(afterRateLoser);
		userManageCrudRepository.saveAll(ttUsers);
		// userManageCrudRepository.save(winner);
		// userManageCrudRepository.save(loser);
	}
		// 実力差に応じたスコアの期待値を計算する関数
		private double getExpectedScore(int rating1, int rating2) {
			double expectedScore = 1.0 / (1.0 + Math.pow(10.0, (rating2 - rating1) / 400.0));
			return expectedScore;
		}

		// レーティングを更新する関数
		private int updateRating(int rating, double score, double kFactor, int result) {
			int newRating = (int) Math.round(rating + kFactor * (result - score));
			return newRating;
		}

	}
