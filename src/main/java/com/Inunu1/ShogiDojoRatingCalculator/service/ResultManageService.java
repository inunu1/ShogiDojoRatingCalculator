package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.repository.ResultManageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultManageService {
    @Autowired
    ResultManageCrudRepository resultManageCrudRepository;

    public List<ResultData> findAllResult() {
        // すべてのユーザ情報を取得する
        return resultManageCrudRepository.getResult();
    }
}
