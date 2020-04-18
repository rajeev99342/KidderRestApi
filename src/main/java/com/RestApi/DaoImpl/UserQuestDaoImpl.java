package com.RestApi.DaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RestApi.Dao.UserQuestImgDao;
import com.RestApi.Dao.UserQuestionDao;
import com.RestApi.Model.UserQuestionModel;
import com.RestApi.Model.QuizModel;
@Repository
public class UserQuestDaoImpl implements UserQuestionDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	KeyHolder autoGenereatedId = new GeneratedKeyHolder();
	private int quest_txt_id;
	private int quest_img_id;
	private int quest_dgrm_id;
//	private static List<Integer> questionIds;
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	 @Autowired
	 userQuestImgDaoImpl imageDaoImpl;
	 
	 private SqlParameterSource getUserQuestionSqlParameterByModel(UserQuestionModel questionModel) {
			MapSqlParameterSource paramSource = new MapSqlParameterSource();
			if(questionModel !=null) {
				paramSource.addValue("user_quest_txt_id", quest_txt_id);
				paramSource.addValue("user_quest_img_id", quest_img_id);
				paramSource.addValue("user_quest_dgrm_id", quest_dgrm_id);
				paramSource.addValue("user_quest_optionA", questionModel.getUser_quest_optionA());
				paramSource.addValue("user_quest_optionB", questionModel.getUser_quest_optionB());
				paramSource.addValue("user_quest_optionC", questionModel.getUser_quest_optionC());
				paramSource.addValue("user_quest_optionD", questionModel.getUser_quest_optionD());
				paramSource.addValue("user_quest_ans", questionModel.getUser_quest_ans());
				paramSource.addValue("user_quest_creator", questionModel.getUser_quest_creator());
				paramSource.addValue("user_quest_marks", questionModel.getUser_quest_marks());
				paramSource.addValue("user_quest_id", questionModel.getUser_quest_id());
				paramSource.addValue("isEdit", questionModel.isEdit());
				paramSource.addValue("quiz_id", questionModel.getQuiz_id());
			}
			return paramSource;
	 }
	 @Transactional
	public List<Integer> batchQuestionInsert(List<UserQuestionModel> userQuestionModel) {
		 List<Integer> questionIds = new ArrayList<Integer>();
		String sql = "insert into user_quest_info_tbl (user_quest_txt_id, user_quest_img_id, user_quest_dgrm_id, quiz_id, user_quest_optionA, user_quest_optionB, user_quest_optionC, user_quest_optionD, user_quest_ans, user_quest_creator, quest_marks) values(:user_quest_txt_id, :user_quest_img_id, :user_quest_dgrm_id, :quiz_id, :user_quest_optionA, :user_quest_optionB, :user_quest_optionC, :user_quest_optionD, :user_quest_ans, :user_quest_creator, :user_quest_marks)";
		for(UserQuestionModel question: userQuestionModel) {
			if(question.getUser_quest_img_model() !=null) {
				quest_img_id = imageDaoImpl.insertImage(question.getUser_quest_img_model());
			}
			if(question.getUser_questdgrm_model() !=null) {
				quest_dgrm_id = imageDaoImpl.insertImage(question.getUser_questdgrm_model());
			}
			
			namedParameterJdbcTemplate.update(sql, getUserQuestionSqlParameterByModel(question),autoGenereatedId);
			questionIds.add(autoGenereatedId.getKey().intValue());
		}
		return questionIds;
	}
	

}
