package com.practice1.demo.pojo1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoticeController implements Action {
	Logger logger = LoggerFactory.getLogger(NoticeController.class);
	NoticeLogic nLogic = new NoticeLogic();
	/*경로, 전환방식을 반환하는 ActionForward 객체를 반환 -> ct에게 전달할 정보 담음
	 * ActionForward 객체를 새로 생성하고, 필요한 정보를 설정한 후에 반환*/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String upmu[] = (String[])req.getAttribute("upmu");
		if("noticeList".equals(upmu[1])) {
			logger.info("noticeList");
			List<Map<String,Object>> nList = null;
		}
		else if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			int result = 0;
		}
		else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			int result = 0;
		}
		else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			int result = 0;
		}
		return null;
	}
}
