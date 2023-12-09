package com.example.demo.pojo1;

import com.vo.EmpVO;
import com.vo.NoticeVO;

public class LombokTest {
	void methodA() {
		NoticeVO nvo = 
				NoticeVO.builder().n_no(3)
				.n_title("제목").n_content("내용").n_writer("작성자")
				.build();
		System.out.println(nvo.getN_writer());
		NoticeVO nvo2 = 
				NoticeVO.builder().n_no(3)
				.n_title("제목").n_content("내용").n_writer("작성자")
				.build();
		System.out.println(nvo2.getN_writer());
		NoticeVO nvo3 = 
				NoticeVO.builder().n_no(3)
				.n_title("제목").n_content("내용").n_writer("작성자")
				.build();
		System.out.println(nvo3.getN_writer());
	}
	public static void main(String[] args) {
		LombokTest lt = new LombokTest();
		lt.methodA();
		
		NoticeVO nvo = new NoticeVO();
		nvo.setN_title("휴관공지");
		System.out.println(nvo.getN_title());

		EmpVO evo = new EmpVO();
		evo = new EmpVO(7566);
	}
}
