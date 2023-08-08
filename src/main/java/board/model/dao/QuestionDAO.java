package board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.QuestionBoard;

public class QuestionDAO {

	/*
	 *  RowBounds
	 *  - 쿼리문을 변경하지 않고도 페이징을 처리할 수 있게 해주는 클래스
	 *  RowBounds의 동작은 offset값과 limit값을 이용해서 동작함.
	 *  limit값은 한페이지당 보여주고 싶은 게시물의 갯수
	 *  offset값은 시작값, 변하는 값
	 *  1페이지에서는 0부터 시작해서 10개를 가져오고
	 *  2페이지에서는 10부터 시작해서 10개를 가져오고
	 *  3페이지에서는 20부터 시작해서 10개를 ....
	 */
	public List<QuestionBoard> selectAllQuestion(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		// 넘겨받을 값이 없으니 null로 두고 rowBounds자리는 3번째임
		List<QuestionBoard> qList = session.selectList("QuestionMapper.selectAllQuestion", null, rowBounds);
		return qList;
	}

	public String generatePageNavi(SqlSession session, int currentPage) {
		// 전체 게시물의 갯수
		int totalCount = getTotalCount(session);
		// 한 페이지당 나올 게시물
		int recordCountPerPage = 10;
		// 한 페이지당 보일 하단 버튼 갯수
		int naviCountPerPage = 5;
		int totalNaviCount;
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount / recordCountPerPage + 1;
		}else { 
			totalNaviCount = totalCount / recordCountPerPage;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		if(startNavi != 1) {
			result.append("<a href='/board/questionList.do?currentPage="+(startNavi-1)+"'>[이전]</a>&nbsp");
		}
		
		for(int i = startNavi; i <= endNavi; i++) {			
			result.append("<a href='/board/questionList.do?currentPage="+i+"'>"+i+"</a>&nbsp");
		}
		
		if(endNavi != totalNaviCount) {
			result.append("<a href='/board/questionList.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		
		return result.toString();
	}

	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("QuestionMapper.getTotalCount");
		return totalCount;
	}

	public int questionInsert(SqlSession session, QuestionBoard qboard) {
		int result = session.insert("QuestionMapper.questionInsert", qboard);
		
		return result;
	}

}
