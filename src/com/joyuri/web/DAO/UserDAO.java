package com.joyuri.web.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDAO")
public class UserDAO {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean create(User user) {
		// BeanPropertySqlParameterSource param = new
		// BeanPropertySqlParameterSource(user);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode((user.getPassword())));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());

		jdbc.update(
				"insert into users (username, email, password, enabled) values (:username, :email, :password, :enabled)",
				params);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username = :username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		return jdbc.query("select * from users, authorities", BeanPropertyRowMapper.newInstance(User.class));
	}
}
