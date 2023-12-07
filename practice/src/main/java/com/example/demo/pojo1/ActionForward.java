package com.example.demo.pojo1;

public class ActionForward {
	private String path = null;         //경로 반환
	private boolean isRedirect = false; //전송방식 확인
	//getter & setter -> 캡슐화 -> 직접접근 막기 & 인스턴스화와 메소드로 풀기 
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	} 
}
