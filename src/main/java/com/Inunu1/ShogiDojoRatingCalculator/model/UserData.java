package com.Inunu1.ShogiDojoRatingCalculator.model;

import lombok.Data;

@Data
public class UserData {
	private Integer id;
	private String type;
	private String name;
	private String grade;
	private Integer rate;
	private String joinDate;
	private String password;
	private String updateDate;
}
