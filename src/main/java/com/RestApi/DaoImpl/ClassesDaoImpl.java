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

import com.RestApi.Dao.ClassesDao;
import com.RestApi.Model.Classes;
@Repository
public class ClassesDaoImpl implements ClassesDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	public List<Classes> allClassList() {
		String sql = "select class_id, class_name, class_board_name, class_unique_code from class_tbl";
		List<Classes> classesList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ClassesMapper());
		return classesList;
	}
	private SqlParameterSource getSqlParameterByModel(Classes classes) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return paramSource;
	}
	private static final class ClassesMapper implements RowMapper<Classes>{

		public Classes mapRow(ResultSet rs, int rowNum) throws SQLException {
			Classes classes =new Classes();
			classes.setClass_id(rs.getInt("class_id"));
			classes.setClass_name(rs.getString("class_name"));
			classes.setClass_code(rs.getString("class_unique_code"));
			classes.setClass_board_name(rs.getString("class_board_name"));
			return classes;
		}
		
	}
}
