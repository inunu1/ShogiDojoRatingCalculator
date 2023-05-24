package com.Inunu1.ShogiDojoRatingCalculator.repository;

import com.Inunu1.ShogiDojoRatingCalculator.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LoginUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<LoginUser> findLoginUser(String key) {
        String sql = "SELECT user_name, password "
        		+ "FROM tt_user "
        		+ "WHERE user_name = '" + key + "'";
        return Optional.ofNullable(jdbcTemplate.query(sql, new LoginUserResultSetExtractor()));
    }

    private static class LoginUserResultSetExtractor implements ResultSetExtractor<LoginUser> {

        @Override
        public LoginUser extractData(ResultSet rs) throws SQLException, DataAccessException {
            LoginUser loginUser = new LoginUser();
            List<String> roleList = new ArrayList<>();
            while (rs.next()) {
            	if(rs.isFirst()) {
            		loginUser.setName(rs.getString("user_name"));
            		loginUser.setPassword(rs.getString("password"));
            	}
            	//roleList.add(rs.getString("role_name"));
            }
            loginUser.setRoleList(new ArrayList<>());
            return loginUser;
        }
    }

}
