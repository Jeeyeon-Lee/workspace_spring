package com.practice1.demo.pojo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeLogic { //목록조회 메소드
	Logger logger = LoggerFactory.getLogger(NoticeController.class);
	public List<Map<String,Object>> noticeList() {
		logger.info("noticeList");
		List<Map<String,Object>> nList = new ArrayList<>();
		return nList;
	}
	public int noticeInsert() {
		logger.info("noticeInsert");
		int result = 0;
		return result;
	}
	public int noticeDelete() {
		logger.info("noticeDelete");
		int result = 0;
		return result;
	}
	public int noticeUpdate() {
		logger.info("noticeUpdate");
		int result = 0;
		return result;
	}
}
