package com.util;

import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;

public class HashMapBinder {
	Logger logger = LoggerFactory.getLogger(HashMapBinder.class);
	//반복해서 작성해야하는 Requst.getparameter를 조금 바꿔보자
	//왜? 리턴타입이 아닌 파라미터자리로 받게 되면 외부 클래스에서 인스턴스화 되어 넘어옴
	//단, 초기화 처리 후 사용해야 함. 
	HttpServletRequest req = null;
	/* ***********************************************************
	 * @param pMap - 필요한 클래스 주입 - 선언의 자리, 생성의 자리가 아님. 
	 ********************************************************** */
	public HashMapBinder(HttpServletRequest req) {
		this.req =req;
	}
	public void bind(Map<String, Object> pMap) {
		//pMap을 비운뒤에 받기 
		pMap.clear();
		//<input type="text" name="n_title">
		//<input type="text" name="n_content">
		//<input type="text" name="n_writer">
		//Enumeration<String> jakarta.servlet.ServletRequest.getParameterNames()
		//Enumeration이 n_title, n_content, n_writer 인풋타입으로 받아줌
		Enumeration<String> em = req.getParameterNames();
		//boolean java.util.Enumeration.hasMoreElements()
		//한 번에 하나씩 일련의 요소를 생성합니다. 
		//nextElement 메소드에 대한 연속 호출은 시리즈의 연속 요소를 반환합니다.
		while(em.hasMoreElements()) {
			//키값들을 꺼내서 넣기
			String key = em.nextElement(); //n_title, n_content, n_writer
			pMap.put(key, req.getParameter(key));
		}
		logger.info(pMap.toString());
	}
}
