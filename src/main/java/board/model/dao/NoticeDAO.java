package board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.vo.Notice;

public class NoticeDAO {

	public List<Notice> selectNoticeList(SqlSession session) {
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList");
		return nList;
	}
}
