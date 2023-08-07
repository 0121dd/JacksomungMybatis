package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		String resource = "mybatis-config.xml";
		SqlSession session = null;
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			// 연결하는 사람
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 연결하는 사람이 공장을 세움
			SqlSessionFactory factory = builder.build(is);
			// 공장 열음
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
