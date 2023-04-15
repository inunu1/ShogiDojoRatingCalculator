package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import com.Inunu1.ShogiDojoRatingCalculator.repository.ResultManageCrudRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    @Autowired
    ResultManageCrudRepository resultCrudRepository;

    public void saveResult(ResultData resultData) {
        TtGameResult ttGameResult = new TtGameResult();
        // 画面から引き渡しされたUserDataオブジェクトを、TtUserにコピー。
        BeanUtils.copyProperties(resultData, ttGameResult);
        // DBへの書き込み処理。
        //ttUser.setUpdateDate(DateTimeUtil.getNowDateStr("yyyyMMddHHmmss"));
        resultCrudRepository.save(ttGameResult);
    }
}
