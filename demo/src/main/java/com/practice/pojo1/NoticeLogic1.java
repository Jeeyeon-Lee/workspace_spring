package com.practice.pojo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis.mapper.MyBatisCommonFactory;

//DB연동 클래스
public class NoticeLogic1 {
	//선언부
	Logger logger = LoggerFactory.getLogger(NoticeLogic1.class);
	//DB 연결 관련 with MyBaticCommonFactory
	SqlSessionFactory sqlSessionFactory = null;
	
	//noticeList() -> 공지사항 목록에 대한 메소드
	public List<Map<String, Object>> noticeList() {
		logger.info("noticeList()");
		List<Map<String, Object>> nList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			nList = sqlSession.selectList("noticeList");
			logger.info("nList.toString()");
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return nList;
	}
	
	//noticeInsert() -> 추가에 대한 메소드
	public int noticeInsert() {
		logger.info("noticeInsert");
		int result = 0;
		result = 1;
		return result;
	}
	//noticeUpdate() -> 추가에 대한 메소드
	public int noticeUpdate() {
		logger.info("noticeUpdate");
		int result = 0;
		result = 1;
		return result;
	}
	//noticeDelete() -> 추가에 대한 메소드
	public int noticeDelete() {
		logger.info("noticeDelete");
		int result = 0;
		result = 1;
		return result;
	}

}
