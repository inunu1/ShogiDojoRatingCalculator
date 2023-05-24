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
@Table(name = "tt_user")
public class TtUser {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_type")
	private String type;

	@Column(name = "user_name")
	private String name;
	
	@Column(name = "rate")
	private Integer rate;

	@Column(name = "grade")
	private String grade;

	@Column(name = "join_date")
	private String joinDate;

	@Column(name = "update_date")
	private String updateDate;

	@Column(name = "password")
	private String password;
	
}