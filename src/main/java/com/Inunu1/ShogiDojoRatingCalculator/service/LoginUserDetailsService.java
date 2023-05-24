package com.Inunu1.ShogiDojoRatingCalculator.service;

import com.Inunu1.ShogiDojoRatingCalculator.model.LoginUser;
import com.Inunu1.ShogiDojoRatingCalculator.model.LoginUserDetails;
import com.Inunu1.ShogiDojoRatingCalculator.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	private LoginUserRepository loginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String key) throws UsernameNotFoundException {
		Optional<LoginUser> loginUser = loginUserRepository.findLoginUser(key);
		return loginUser.map(user -> new LoginUserDetails(user))
				.orElseThrow(() -> new UsernameNotFoundException("not found"));
	}
}