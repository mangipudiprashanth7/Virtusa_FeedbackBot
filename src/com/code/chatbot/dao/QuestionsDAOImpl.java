package com.code.chatbot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.code.chatbot.model.Questions;

public class QuestionsDAOImpl implements QuestionsDAO {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Questions questions) {
		String sql = "INSERT INTO QUESTIONS(QUESTION) VALUES(?)";
		return jdbcTemplate.update(sql, questions.getQuestion());
	}

	@Override
	public int update(Questions questions) {
		String sql = "UPDATE QUESTIONS SET QUESTION=? WHERE QID=?";
		return jdbcTemplate.update(sql, questions.getQuestion(), questions.getId());
	}

	@Override
	public Questions get(Integer id) {
		String sql = "SELECT * FROM QUESTIONS WHERE QID=" + id;
		ResultSetExtractor<Questions> resultSetExtractor = new ResultSetExtractor<Questions>() {

			@Override
			public Questions extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer id = rs.getInt("QID");
					String question = rs.getString("QUESTION");

					return new Questions(id, question);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, resultSetExtractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM QUESTIONS WHERE QID=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Questions> list() {
		String sql = "SELECT * FROM QUESTIONS";
		RowMapper<Questions> rowMapper = new RowMapper<Questions>() {

			@Override
			public Questions mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("QID");
				String question = rs.getString("QUESTION");

				return new Questions(id, question);

			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
