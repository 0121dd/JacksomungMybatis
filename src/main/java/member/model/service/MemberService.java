package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	public Member selectCheckLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member loginCheck = mDao.selectCheckLogin(session, member);
		
		return loginCheck;
	}
	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectOneById(session, memberId);
		
		return mOne;
	}
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.insertMember(session, member);
		
		return result;
	}
	public int updateMember(Member mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session, mOne);
		
		return result;
	}

}
