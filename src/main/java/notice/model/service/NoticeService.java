package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

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
