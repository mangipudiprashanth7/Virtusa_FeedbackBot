package com.code.chatbot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.code.chatbot.model.Admin;
import com.code.chatbot.model.Authenticate;

public class AdminDAOImpl implements AdminDAO {

	private JdbcTemplate jdbcTemplate;

	public AdminDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Admin admin) {
		String sql = "INSERT INTO ADMIN(NAME,AEMAIL,APASS) VALUES(?, ?, ?)";
		return jdbcTemplate.update(sql, admin.getName(), admin.getEmail(), admin.getPassword());
	}

	@Override
	public int update(Admin admin) {
		String sql = "UPDATE ADMIN SET NAME=?, AEMAIL=?, APASS=? where AID=?";
		return jdbcTemplate.update(sql, admin.getName(), admin.getEmail(), admin.getPassword(), admin.getId());
	}

	@Override
	public Admin get(Integer aid) {
		String sql = "SELECT * FROM ADMIN WHERE AID=" + aid;

		ResultSetExtractor<Admin> extractor = new ResultSetExtractor<Admin>() {

			@Override
			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("NAME");
					String email = rs.getString("AEMAIL");
					String password = rs.getString("APASS");

					return new Admin(aid, name, email, password);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<Admin> list() {
		String sql = "SELECT * FROM ADMIN";
		RowMapper<Admin> rowMapper = new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("AID");
				String name = rs.getString("NAME");
				String email = rs.getString("AEMAIL");
				String password = rs.getString("APASS");

				return new Admin(id, name, email, password);

			}

		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int delete(Integer aid) {
		String sql = "DELETE FROM ADMIN WHERE AID=" + aid;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int verify(Authenticate authenticate) {
		String sql = "SELECT APASS FROM ADMIN WHERE AEMAIL=?";

		String result = (String) jdbcTemplate.queryForObject(sql, String.class, authenticate.getEmailString());
		// String result = (String) jdbcTemplate.queryForObject(sql, new Object[]
		// {email}, String.class);
		//System.out.println(result);
		if (authenticate.getPasswordString().equals(result))
			return 1;
		else
			return -1;

	}

}
