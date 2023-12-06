package com.practice.pojo1;

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
public class NoticeController1 implements Action1 {
	Logger logger = LoggerFactory.getLogger(NoticeController1.class);
	NoticeLogic1 nLogic = new NoticeLogic1();//이른 인스턴스화
	@Override
	public ActionForward1 execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String n_title = req.getParameter("n_title");
		String n_content = req.getParameter("n_content");
		String n_writer = req.getParameter("n_writer");
		logger.info(n_title+", "+n_content+", "+n_writer);
		String upmu[] = (String[])req.getAttribute("upmu");
		ActionForward1 af = new ActionForward1();
		//String이 아닌 builder, buffer를 사용하여 저장해야 함.(컴퓨터 과부하 됨) 
		StringBuilder path = new StringBuilder();
		boolean isRedirect = false;
 		path.append("/notice/");
		/*select*/
		if ("noticeList".equals(upmu[1])) {// select
			logger.info("noticeList");
			List<Map<String, Object>> nList = null;
			nList = nLogic.noticeList();
			req.setAttribute("nList", nList);
			path.append("noticeList.jsp");
			isRedirect = false;// false이면 forward처리됨
		}
		//화면 출력을 ReactJS와 같이 다른 언어 다른 라이브러리 사용하여 처리해야할 땐
		//Backend 에서 해야할 일은 JSON 포맷으로 응답이 나가도록 처리해줘야 한다.
		//POJO 1-3 버전에서는 이 부분도 공통코드로 담아본다. 
		else if ("jsonNoticeList".equals(upmu[1])) {// select
			logger.info("jsonNoticeList");
			List<Map<String, Object>> nList = null;
			nList = nLogic.noticeList();
			req.setAttribute("nList", nList);
			path.append("jsonNoticeList.jsp");
			isRedirect = false;// false이면 forward처리됨
		}

		/* insert
		 * 어디서 입력받나?? JSP에서 입력받음 -> action 타고(noticeInsert.gd) -> 1나오면 성공 
		 * action 타고(select) jsp */
		else if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			int result = 0;
			result = nLogic.noticeInsert();
			if(result ==1) {
				path.append("noticeList.gd");
				isRedirect = true;
			}else {
				path.append("jsonNoticeError.jsp");
				isRedirect = true;
			}
		/*Update*/
		}else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			int result = 0;
			result = nLogic.noticeUpdate();
			if(result == 1) {
				path.append("noticeUpdate.gd");
				isRedirect = true;
			}else {
				path.append("noticeError.jsp");
				isRedirect = true;
			}
		/*Delete*/
		}else if("noticeDelete".equals(upmu[1])) {
			logger.info("noticeDelete");
			int result = 0;
			result = nLogic.noticeDelete();
			if(result == 1) {
				path.append("noticeDelete.gd");
				isRedirect = true;
			}else {
				path.append("noticeError.jsp");
				isRedirect = true;
			}
		}
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
		}

}
