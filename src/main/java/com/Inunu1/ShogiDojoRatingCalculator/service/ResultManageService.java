package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.repository.ResultManageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultManageService {
    @Autowired
    ResultManageCrudRepository resultManageCrudRepository;

    public List<ResultData> findAllResult() {
        // すべてのユーザ情報を取得する
        List<Object[]> resultList = resultManageCrudRepository.getResult();
        List<ResultData> resultDataList = new ArrayList<>();
        for (Object[] result : resultList) {
            ResultData resultData = new ResultData();
            resultData.setGame_date((String) result[0]);
            resultData.setWinner((String) result[1]);
            resultData.setLoser((String) result[2]);
            resultDataList.add(resultData);
        }
        return resultDataList;
    }
}
