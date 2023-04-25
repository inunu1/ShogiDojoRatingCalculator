package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import com.Inunu1.ShogiDojoRatingCalculator.repository.ResultManageCrudRepository;
import org.springframework.beans.BeanUtils;
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
        List<TtGameResult> ttGameResults = resultManageCrudRepository.findAll();
        List<ResultData> resultDatas = new ArrayList<>();
        // 取得したユーザ情報を画面表示用のオブジェクトに詰め替える
        for (TtGameResult ttGameResult : ttGameResults) {
            ResultData resultData = new ResultData();
            BeanUtils.copyProperties(ttGameResult, resultData);
            resultDatas.add(resultData);
        }
        return resultDatas;
    }
}
