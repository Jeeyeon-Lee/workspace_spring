package com.example.demo.pojo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//DB연동 클래스
public class NoticeLogic {
	Logger logger = LoggerFactory.getLogger(NoticeLogic.class);
	//select일 때 넣는 정보 
	public List<Map<String, Object>> noticeList(){
		//Nullexeption맞을 수 있으니 일단 수정해두고 진행(원래는 null로 설정)
//		List<Map<String, Object>> nList = null;
		logger.info("noticeList");
		List<Map<String, Object>> nList = new ArrayList<>();
		return nList;
	}
	public int noticeInsert() {
		logger.info("noticeList");
		int resurt = 0;
		return resurt;
	}
	public int noticeDelete() {
		logger.info("noticeDelete");
		int resurt = 0;
		return resurt;
	}
	public int noticeUpdate() {
		logger.info("noticeUpdate");
		int resurt = 0;
		return resurt;
	}
}
