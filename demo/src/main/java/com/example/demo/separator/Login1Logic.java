package com.example.demo.separator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//순수한 자바 클래스 -> 이식성 관련(어디에 넣더라도 트러블 없이 잘동작하도록)
//요청에 대한 처리 전담 클래스 
//다른 프레임워크 이관작업 되도 최소의 코드 수정으로 적용 가능함. 
public class Login1Logic {
	Logger logger = LoggerFactory.getLogger(Login1Logic.class);

	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		String db_id = "kiwi";
		String db_pw = "123";
		String db_name = "키위";
		if(mem_id.equals(db_id)) {
			if(mem_pw.equals(db_pw)) {
				mem_name = db_name;
			}else{
				mem_name = "비밀번호가 맞지 않습니다.";
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
		return mem_name;
	}
}
