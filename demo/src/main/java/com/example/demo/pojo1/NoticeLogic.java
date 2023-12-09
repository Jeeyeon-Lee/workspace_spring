package com.example.demo.pojo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.util.MyBatisCommonFactory;


//DB연동 클래스
public class NoticeLogic {
	Logger logger = LoggerFactory.getLogger(NoticeLogic.class);
	//DB관련 마이바티스 활용 -> MyBatisCommonFactory 클래스 
	SqlSessionFactory sqlSessionFactory = null;
	//select일 때 넣는 정보 
	public List<Map<String, Object>> noticeList(Map<String, Object>pMap){
		//Nullexeption맞을 수 있으니 일단 수정해두고 진행(원래는 null로 설정)
//		List<Map<String, Object>> nList = null;
		logger.info("noticeList");
		logger.info(pMap.toString());
		List<Map<String,Object>> nList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//예외 처리를 위한 try-catch 반드시 사용
		try {
			nList = sqlSession.selectList("noticeList",pMap);
			logger.info(nList.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return nList;
	}
	public List<Map<String, Object>> procNoticeList(Map<String,Object>pMap){
		logger.info("procNoticeList");
		logger.info(pMap.toString());
		List<Map<String,Object>> nList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//예외 처리를 위한 try-catch 반드시 사용
		try {
			nList = sqlSession.selectList("proc_noticeList",pMap);
			logger.info(pMap.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return nList;
	}
	public int noticeInsert(Map<String, Object> pMap){
		logger.info("noticeInsert");
		int result = 0;
		//DB연결
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("noticeInsert", pMap); 
			sqlSession.commit(); //물리적 테이블에 반영됨 (빼먹지 말기!)
		} catch (Exception e) {
			logger.info(e.toString());
		}
		result = 1;
		return result;
	}
	public int noticeUpdate(Map<String, Object> pMap){
		logger.info("noticeUpdate");
		int result = 0;
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.update("noticeUpdate", pMap); 
			sqlSession.commit(); //물리적 테이블에 반영됨 (빼먹지 말기!)
		} catch (Exception e) {
			logger.info(e.toString());
		}
		result = 1;
		return result;
	}  
	
	//쿼리문 실행에 중요한 것은 	result = sqlSession.delete("noticeDelete", pMap); "아이디"이다.
	public int noticeDelete(Map<String, Object> pMap){
		logger.info("noticeDelete");
		int result = 0;
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.delete("noticeDelete", pMap);
			sqlSession.commit(); //이걸 빼먹으면 물리적인 테이블 반영 안 됨
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return result;
	}
}
