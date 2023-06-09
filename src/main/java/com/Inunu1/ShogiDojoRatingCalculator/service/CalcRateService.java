package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;
import com.Inunu1.ShogiDojoRatingCalculator.repository.UserManageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CalcRateService {
    @Autowired
    private UserManageCrudRepository userManageCrudRepository;

    public void calcRate(Integer winnerId, Integer loserId) {
    
    	private static final Integer K_FACTOR = 16;
    	private static final Integer RESULT_WIN = 1;
 	private static final Integer RESULT_LOSE = 0;

 	// 1.勝者、敗者のユーザー情報を取得
    	List<Integer> userIds = new ArrayList<>();
    	userIds.add(winnerId);
    	userIds.add(loserId);

}
