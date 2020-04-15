package com.RestApi.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.RestApi.Common.CommonResource;
import com.RestApi.Dao.UserDao;
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
			paramSource.addValue("user_unique_code", userModel.getUser_unique_code());
			paramSource.addValue("user_password", userModel.getUser_password());
			paramSource.addValue("user_id", userModel.getUser_id());
			paramSource.addValue("user_phone_number", userModel.getUser_phone_number());
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
			userModel.setUser_unique_code(rs.getString("user_unique_code"));
			userModel.setUser_password(rs.getString("user_password"));
			userModel.setUser_phone_number(rs.getInt("user_phone_number"));
			return userModel;
		}
		
	}
	public void saveUserDetail(UserModel userModel) {
		String sql = "insert into user_info_tbl(user_name, user_username, user_password, user_email, user_phone_number, user_unique_code) values(:user_name, :user_username, :user_password, :user_email, :user_phone_number, :user_unique_code)";
		if(userModel.getUser_unique_code() == null) {
			userModel.setUser_unique_code(CommonResource.randomString((20 - userModel.getUser_username().length())) + userModel.getUser_username().toUpperCase());
		}
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userModel));
		
	}
}
