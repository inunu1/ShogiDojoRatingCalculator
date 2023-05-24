package com.Inunu1.ShogiDojoRatingCalculator;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ApplicationTests {


	public class LocalTEST {



		public static void main(String[] args) {

		BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();

		System.out.println(encorder.encode("0240436"));

}

	}

}

