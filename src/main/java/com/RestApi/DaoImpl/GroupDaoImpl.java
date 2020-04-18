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

import com.RestApi.Common.CommonResource;
import com.RestApi.Dao.GroupDao;
import com.RestApi.Model.GroupModel;
import com.RestApi.Model.UserModel;
@Repository
public class GroupDaoImpl implements GroupDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	private SqlParameterSource getSqlParameterByModel(GroupModel groupModel) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(groupModel !=null) {
			paramSource.addValue("grp_id", groupModel.getGrp_id());
			paramSource.addValue("grp_admin", groupModel.getGrp_admin());
			paramSource.addValue("grp_name", groupModel.getGrp_name());
			paramSource.addValue("grp_desc", groupModel.getGrp_desc());
			paramSource.addValue("grp_unique_code", groupModel.getGrp_unique_code());
		}
		return paramSource;
	}
	private static final class GroupModelMapper implements RowMapper<GroupModel>{

		public GroupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			GroupModel groupModel =new GroupModel();
			groupModel.setGrp_id(rs.getInt("grp_id"));
			groupModel.setGrp_admin(rs.getString("grp_admin"));
			groupModel.setGrp_desc(rs.getString("grp_desc"));
			groupModel.setGrp_name(rs.getString("grp_name"));
			groupModel.setGrp_unique_code(rs.getString("grp_unique_code"));
			return groupModel;
		}
		
	}
	public String saveGroupDetail(GroupModel groupModel){
		String sql = "insert into group_info_tbl(grp_name, grp_desc, grp_admin, grp_unique_code) values(:grp_name, :grp_desc, :grp_admin, :grp_unique_code)";
		if(getGroupDetailsByGroupName(groupModel.getGrp_name()).size() ==0) {
		if(groupModel.getGrp_unique_code() == null) {
			groupModel.setGrp_unique_code(CommonResource.randomString((20 - groupModel.getGrp_name().length())) + groupModel.getGrp_name().toUpperCase());
		}
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(groupModel));
		} else {
			return "Group Name Alredy Exist";
		}
		return "Group created Succesfully";
		
	}
	public List<GroupModel> getGroupDetailsByGroupName(String grpName) {
		String sql = "select * from group_info_tbl where grp_name=:grp_name";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("grp_name",grpName);
		return namedParameterJdbcTemplate.query(sql, namedParameters, new GroupModelMapper());
	}
}
