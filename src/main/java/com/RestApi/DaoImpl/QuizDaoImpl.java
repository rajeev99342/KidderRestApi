package com.RestApi.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RestApi.Common.CommonResource;
import com.RestApi.Dao.QuizDao;
import com.RestApi.Model.QuizModel;
import com.RestApi.Model.Subjects;

@Repository
public class QuizDaoImpl implements QuizDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	KeyHolder autoGenereatedId = new GeneratedKeyHolder();
	 @Autowired
	 UserQuestDaoImpl questionDaoImpl;
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }
	 private SqlParameterSource getSqlParameterByModel(QuizModel quizModel) {
			MapSqlParameterSource paramSource = new MapSqlParameterSource();
			if(quizModel !=null) {
				paramSource.addValue("quiz_id", quizModel.getQuiz_id());
				paramSource.addValue("quiz_name", quizModel.getQuiz_name());
				paramSource.addValue("grp_name", quizModel.getGrp_name());
				paramSource.addValue("quiz_exam", quizModel.getQuiz_exam());
				paramSource.addValue("quiz_sub", quizModel.getQuiz_sub());
				
				paramSource.addValue("quiz_topic", quizModel.getQuiz_topic());
				paramSource.addValue("quiz_created_date", quizModel.getQuiz_created_date());
				paramSource.addValue("quiz_published_date", quizModel.getQuiz_published_date());
				paramSource.addValue("quiz_time", quizModel.getQuiz_time());
				paramSource.addValue("quiz_duration", quizModel.getQuiz_duration());
				
				paramSource.addValue("quiz_creator", quizModel.getQuiz_creator());
				paramSource.addValue("quiz_marks", quizModel.getQuiz_marks());
				paramSource.addValue("quiz_num_of_ques", quizModel.getQuiz_num_of_ques());
				
			}
			return paramSource;
		}
	 private static final class QuizModelMapper implements RowMapper<QuizModel>{

			public QuizModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				QuizModel quizModel =new QuizModel();
				quizModel.setQuiz_id(rs.getInt("quiz_id"));
				quizModel.setQuiz_name(rs.getString("quiz_name"));
				quizModel.setGrp_name(rs.getString("grp_name"));
				quizModel.setQuiz_created_date(rs.getDate("quiz_created_date"));
				quizModel.setQuiz_creator(rs.getString("quiz_creator"));
				quizModel.setQuiz_published_date(rs.getDate("quiz_published_date"));
				quizModel.setQuiz_time(rs.getTime("quiz_time"));
				quizModel.setQuiz_duration(rs.getInt("quiz_duration"));
				quizModel.setQuiz_marks(rs.getDouble("quiz_marks"));
				quizModel.setQuiz_num_of_ques(rs.getInt("quiz_num_of_ques"));
				return quizModel;
			}
			
		}
	 @Transactional
	public void saveQuizDetail(QuizModel quizModel) {
		String sql = "insert into quiz_info_tbl(quiz_name, grp_name, quiz_created_date, quiz_published_date, quiz_time, quiz_duration, quiz_creator, quiz_marks, quiz_num_of_ques) values(:quiz_name, :grp_name, :quiz_created_date, :quiz_published_date, :quiz_time, :quiz_duration, :quiz_creator, :quiz_marks, :quiz_num_of_ques)";
		if (quizModel.getQuiz_created_date() == null) {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);
			System.out.println("++++++++++++++"+date);
			quizModel.setQuiz_created_date(date);
		}
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(quizModel),autoGenereatedId);
		quizModel.setQuiz_id(autoGenereatedId.getKey().intValue());
		if(quizModel.getUser_questlist().size() !=0) {
			for(int i=0;i<quizModel.getUser_questlist().size();i++) {
				quizModel.getUser_questlist().get(i).setQuiz_id(autoGenereatedId.getKey().intValue());
				
			}
//			questionDaoImpl.batchQuestionInsert(quizModel.getQuest_list());
			if(quizModel.getQuest_ids_list() == null) {
				quizModel.setQuest_ids_list(new ArrayList<Integer>());
			}
			quizModel.getQuest_ids_list().addAll(questionDaoImpl.batchQuestionInsert(quizModel.getUser_questlist()));
		}
		if(quizModel.getQuest_ids_list().size() !=0) {
			saveQuizQuestionMapDetail(quizModel);
		}
		
		
	}
	
	@SuppressWarnings("null")
	@Transactional
	public void saveQuizQuestionMapDetail(QuizModel quizModel) {
		Map<String, Object> map;
		List<Map<String, Object>> parameters = new ArrayList<Map<String,Object>>();
		for(int i=0;i< quizModel.getQuest_ids_list().size(); i++) {
			map = new HashMap<String, Object>();
			map.put("quiz_id",quizModel.getQuiz_id());
			map.put("quest_id",quizModel.getQuest_ids_list().get(i));
			parameters.add(map);
		}
		SqlParameterSource[] paramSource = SqlParameterSourceUtils.createBatch(parameters);
		namedParameterJdbcTemplate.batchUpdate("insert into quiz_question_map_tbl(quiz_id, quest_id) values(:quiz_id, :quest_id)",paramSource);
	}

}
