package com.code.chatbot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.code.chatbot.model.Responses;

public class ResponsesDAOImpl implements ResponsesDAO {

	private JdbcTemplate jdbcTemplate;

	public ResponsesDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Responses responses) {
		String sql = "INSERT INTO RESPONSES(USER,QUESTION,RESPONSE) VALUES(?, ?, ?)";
		return jdbcTemplate.update(sql, responses.getUser(), responses.getQueString(), responses.getResponseString());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM RESPONSES WHERE RID=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public Responses get(Integer id) {
		String sql = "SELECT * FROM RESPONSES WHERE RID" + id;
		ResultSetExtractor<Responses> extractor = new ResultSetExtractor<Responses>() {

			@Override
			public Responses extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer id = rs.getInt("RID");
					String user = rs.getString("USER");
					String question = rs.getString("QUESTION");
					String response = rs.getString("RESPONSE");

					return new Responses(id, user, question, response);

				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int update(Responses responses) {
		String sql = "UPDATE RESPONSES SET USER=?, QUESTION=?, RESPONSE=? WHERE RID=?";
		return jdbcTemplate.update(sql, responses.getUser(), responses.getQueString(), responses.getResponseString(),
				responses.getId());
	}

	@Override
	public List<Responses> list() {
		String sql = "SELECT * FROM RESPONSES";
		RowMapper<Responses> rowMapper = new RowMapper<Responses>() {

			@Override
			public Responses mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("RID");
				String user = rs.getString("USER");
				String queString = rs.getString("QUESTION");
				String responseString = rs.getString("RESPONSE");

				return new Responses(id, user, queString, responseString);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
