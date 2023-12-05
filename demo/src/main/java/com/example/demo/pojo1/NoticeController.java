package com.example.demo.pojo1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿 상속받지 않고(결합도 낮춰서) 그게 프레임워크 중요 사상 하나이니까
//서블릿이 아닌데 req와 res는 어디서 주입받지? 전처리부가 필요하다!! 
public class NoticeController implements Action {
	Logger logger = LoggerFactory.getLogger(NoticeController.class);
	NoticeLogic nLogic = new NoticeLogic();//이른 인스턴스화
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String upmu[] = (String[])req.getAttribute("upmu");
		/*select*/
		if("noticeList".equals(upmu[1])) {
			logger.info("noticeList");
			List<Map<String,Object>> nList = null;
		}
		/*insert*/
		else if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			int result = 0;
		/*Update*/
		}else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			int result = 0;
		/*Delete*/
		}else if("noticeDelete".equals(upmu[1])) {
			logger.info("noticeDelete");
			int result = 0;
		}
		return null;
	}

}
