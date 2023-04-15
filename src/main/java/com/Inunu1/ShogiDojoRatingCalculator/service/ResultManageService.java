package com.Inunu1.ShogiDojoRatingCalculator.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Inunu1.ShogiDojoRatingCalculator.Code.Grade;
import com.Inunu1.ShogiDojoRatingCalculator.Code.UserType;
import com.Inunu1.ShogiDojoRatingCalculator.Util.DateTimeUtil;
import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import com.Inunu1.ShogiDojoRatingCalculator.repository.ResultManageCrudRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;
import com.Inunu1.ShogiDojoRatingCalculator.model.UserData;
import com.Inunu1.ShogiDojoRatingCalculator.repository.UserManageCrudRepository;

@Service
public class ResultManageService {
    @Autowired
    ResultManageCrudRepository resultManageCrudRepository;

    public List<ResultData> findAllResult() {
        // すべてのユーザ情報を取得する
        List<TtGameResult> ttGameResults = resultManageCrudRepository.findAll();
        List<UserData> userDatas = new ArrayList<>();
        // 取得したユーザ情報を画面表示用のオブジェクトに詰め替える
        for (TtUser ttUser : ttUsers) {
            UserData userData = new UserData();
            BeanUtils.copyProperties(ttUser, userData);
            Grade grade = Grade.getGradeByCode(ttUser.getGrade());
            userData.setGrade(grade.getName());

            UserType userType = UserType.getUserTypeByCode(ttUser.getType());
            userData.setType(userType.getName());
            userDatas.add(userData);
        }
        return userDatas;
    }
}
