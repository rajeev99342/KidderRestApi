package com.RestApi.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.RestApi.Dao.SubjectsDao;
import com.RestApi.Model.Subjects;
@Repository
public class SubjectsDaoImpl implements SubjectsDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	public List<Subjects> allSubjectList() {
		String sql = "select class_id, sub_id, sub_name, sub_unique_code from subject_tbl";
		List<Subjects> subjectList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new SubjectsMapper());
		return subjectList;
	}
	private SqlParameterSource getSqlParameterByModel(Subjects subjec) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return paramSource;
	}
	private static final class SubjectsMapper implements RowMapper<Subjects>{

		public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
			Subjects subjects =new Subjects();
			subjects.setClass_id(rs.getInt("class_id"));
			subjects.setSub_id(rs.getInt("sub_id"));
			subjects.setSub_code(rs.getString("sub_unique_code"));
			subjects.setSub_name(rs.getString("sub_name"));
			return subjects;
		}
		
	}
}
