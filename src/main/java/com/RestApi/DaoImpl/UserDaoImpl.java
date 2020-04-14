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

import com.RestApi.Dao.UserDao;
import com.RestApi.Model.Classes;
import com.RestApi.Model.UserModel;
@Repository
public class UserDaoImpl implements UserDao{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	private SqlParameterSource getSqlParameterByModel(UserModel userModel) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(userModel !=null) {
			paramSource.addValue("user_name", userModel.getUser_name());
			paramSource.addValue("user_username", userModel.getUser_username());
			paramSource.addValue("user_email", userModel.getUser_email());
			paramSource.addValue("user_website", userModel.getUser_website());
			paramSource.addValue("user_referal_threshold", userModel.getUser_referal_threshold());
			paramSource.addValue("user_institute", userModel.getUser_institute());
			paramSource.addValue("user_address", userModel.getUser_address());
			paramSource.addValue("user_type", userModel.getUser_type());
			paramSource.addValue("user_refer_code", userModel.getUser_refer_code());
			paramSource.addValue("user_refer_from", userModel.getUser_refer_from());
			paramSource.addValue("user_isCompetator", userModel.getUser_isCompetator());
			paramSource.addValue("user_unique_code", userModel.getUser_unique_code());
			paramSource.addValue("user_password", userModel.getUser_password());
			paramSource.addValue("user_id", userModel.getUser_id());
		}
		return paramSource;
	}
	private static final class UserModelMapper implements RowMapper<UserModel>{

		public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserModel userModel =new UserModel();
			userModel.setUser_id(rs.getInt("user_id"));
			userModel.setUser_name(rs.getString("user_name"));
			userModel.setUser_username(rs.getString("user_username"));
			userModel.setUser_email(rs.getString("user_email"));
			userModel.setUser_website(rs.getString("user_website"));
			userModel.setUser_address(rs.getString("user_address"));
			userModel.setUser_institute(rs.getString("user_institute"));
			userModel.setUser_type(rs.getInt("user_type"));
			userModel.setUser_unique_code(rs.getString("user_unique_code"));
			userModel.setUser_isCompetator(rs.getBoolean("user_isCompetator"));
			userModel.setUser_refer_code(rs.getString("user_refer_code"));
			userModel.setUser_refer_from(rs.getString("user_refer_from"));
			userModel.setUser_password(rs.getString("user_password"));
			userModel.setUser_referal_threshold(rs.getInt("user_referal_threshold"));
			return userModel;
		}
		
	}
	public void saveUserDetail(UserModel userModel) {
		String sql = "insert into user_info_tbl(user_name, user_username, user_password, user_email, user_website, user_referal_threshold, user_institute, user_address, user_type, user_refer_code, user_refer_from, user_isCompetator, user_unique_code) values(:user_name, :user_username, :user_password, :user_email, :user_website, :user_referal_threshold, :user_institute, :user_address, :user_type, :user_refer_code, :user_refer_from, :user_isCompetator, :user_unique_code)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userModel));
		
	}
}
