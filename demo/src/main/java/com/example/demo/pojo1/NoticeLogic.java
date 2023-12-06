package com.example.demo.pojo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis.mapper.MyBatisCommonFactory;

//DB연동 클래스
public class NoticeLogic {
	Logger logger = LoggerFactory.getLogger(NoticeLogic.class);
	//DB관련 마이바티스 활용 -> MyBatisCommonFactory 클래스 
	SqlSessionFactory sqlSessionFactory = null;
	//select일 때 넣는 정보 
	public List<Map<String, Object>> noticeList(){
		//Nullexeption맞을 수 있으니 일단 수정해두고 진행(원래는 null로 설정)
//		List<Map<String, Object>> nList = null;
		logger.info("noticeList");
		List<Map<String,Object>> nList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//예외 처리를 위한 try-catch 반드시 사용
		try {
			nList = sqlSession.selectList("noticeList");
			logger.info(nList.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return nList;
	}
	public int noticeInsert(){
		logger.info("noticeInsert");
		int result = 0;
		result = 1;
		return result;
	}
	public int noticeUpdate(){
		logger.info("noticeUpdate");
		int result = 0;
		return result;
	}
	public int noticeDelete(){
		logger.info("noticeDelete");
		int result = 0;
		return result;
	}
}
