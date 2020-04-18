package com.RestApi.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.RestApi.Common.CommonResource;
import com.RestApi.Dao.UserQuestImgDao;
import com.RestApi.Model.UserQuestImgModel;
@Repository
public class userQuestImgDaoImpl implements UserQuestImgDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	KeyHolder autoGenereatedId = new GeneratedKeyHolder();
	
	@Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	private SqlParameterSource getSqlParameterByModel(UserQuestImgModel userQuestImageModel) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(userQuestImageModel !=null) {
			paramSource.addValue("img_base64_url", userQuestImageModel.getUser_quest_img_base64_url());
			paramSource.addValue("img_id", userQuestImageModel.getUser_quest_img_id());
			paramSource.addValue("img_desc", userQuestImageModel.getUser_quest_img_desc());
			paramSource.addValue("img_path", userQuestImageModel.getUser_quest_img_path());
			paramSource.addValue("is_quest_img", userQuestImageModel.isUser_quest_img_isQuest());
			paramSource.addValue("is_dgrm_img", userQuestImageModel.isUser_quest_img_isDgrm());
			paramSource.addValue("img_name", userQuestImageModel.getUser_quest_img_name());
		}
		return paramSource;
	}

	public int insertImage(UserQuestImgModel userQuestImageModel) {
		String sql="insert into image_info_tbl (img_desc, img_path, is_quest_img, is_dgrm_img) values(:img_desc, :img_path, :is_quest_img, :is_dgrm_img)";
		String imgName = CommonResource.randomString(5).toUpperCase();
		if(userQuestImageModel.getUser_quest_img_base64_url()!=null) {
		userQuestImageModel.setUser_quest_img_path(CommonResource.StoreBase64Image(userQuestImageModel.getUser_quest_img_base64_url(), imgName));
		userQuestImageModel.setUser_quest_img_name(imgName);;
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userQuestImageModel),autoGenereatedId);
		return autoGenereatedId.getKey().intValue();
		} 
		return 0;
	}

}
