package board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.NoticeDAO;
import board.model.vo.Notice;
import common.SqlSessionTemplate;

public class NoticeService {
	
	private NoticeDAO nDao;
	
	public NoticeService() {
		nDao = new NoticeDAO();
	}

	public List<Notice> selectNoticeList() {
		SqlSession session  = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session);
		return nList;
	}

}
