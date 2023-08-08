package board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.QuestionDAO;
import board.model.vo.PageData;
import board.model.vo.QuestionBoard;
import common.SqlSessionTemplate;

public class QuestionService {
	private QuestionDAO qDao;
	
	public QuestionService() {
		qDao = new QuestionDAO();
	}
	
	public PageData selectAllQuestion(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<QuestionBoard> qList = qDao.selectAllQuestion(session, currentPage);
		String pageNavi = qDao.generatePageNavi(session, currentPage);
		PageData pd = new PageData(qList, pageNavi);
		session.close();
		return pd;
	}

	public int questionInsert(QuestionBoard qboard) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = qDao.questionInsert(session, qboard);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
