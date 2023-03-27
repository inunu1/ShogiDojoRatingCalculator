package com.Inunu1.ShogiDojoRatingCalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inunu1.ShogiDojoRatingCalculator.model.TtUser;
import com.Inunu1.ShogiDojoRatingCalculator.model.UserData;
import com.Inunu1.ShogiDojoRatingCalculator.repository.UserManageCrudRepository;

@Service
public class UserManageService {

	@Autowired
	UserManageCrudRepository userManageCrudRepository;

	public List<UserData> findAllUser() {
		// すべてのユーザ情報を取得する
		List<TtUser> ttUsers = userManageCrudRepository.findAll();
		List<UserData> userDatas = new ArrayList<>();
		// 取得したユーザ情報を画面表示用のオブジェクトに詰め替える
		for (TtUser ttUser : ttUsers) {
			UserData userData = new UserData();
			BeanUtils.copyProperties(ttUser, userData);
			userDatas.add(userData);
		}
		return userDatas;
	}
	
	public void saveUser(UserData userData) {
		TtUser ttUser = new TtUser();
		// 画面から引き渡しされたUserDataオブジェクトを、TtUserにコピー。
		BeanUtils.copyProperties(userData, ttUser);
		// DBへの書き込み処理。
		userManageCrudRepository.save(ttUser);
	}
	
}
