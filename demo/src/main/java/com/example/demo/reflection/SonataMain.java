package com.example.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SonataMain {

	public static void main(String[] args) throws Exception {
		Sonata myCar = new Sonata();
		//1. 인스턴스화된 객체로부터 class 객체 얻어오기
		//클래스 객체란? 싱글톤, 설계도가 객체로 존재하는 것이다. 
		//클래스 당 한 개만 존재하며, 정보조회, 객체 생성 등의 기능을 제공함. 
		//파일로 존재하는 객체는 사용하기 어려움. 
		
		/*1. 객체에서 얻어오는 방법*/ 
		Class carClass = myCar.getClass();
		//인스턴스를 얻어낼 수도 잇음.
		Sonata yourCar = (Sonata) carClass.newInstance();
		System.out.println(yourCar);
		//아빠가 아닌 아들 메소드로 출력(쉐도우 메소드)
		System.out.println(yourCar.toString());        
		
		/*2. 객체 리터럴로부터 class객체 얻기*/
		carClass = Class.forName("com.example.demo.reflection.Sonata");
		Sonata himCar = (Sonata) carClass.newInstance();
		System.out.println(himCar);                           //hashCode
		System.out.println(himCar.toString());                //getClass
		
		/*3.클래스에 선언된 멤버변수와 메소드 목록 출력하기*/
		
		Field[] myArr = carClass.getDeclaredFields();
		for(Field f : myArr) System.out.println(f.getName()); //notify
		
		//사용자정의 메소드와 오버라이딩 메소드 출력
		Method[] meArr = carClass.getMethods();
		for(Method me : meArr) System.out.println(me.getName()); //notifyAll
		System.out.println("============================");
		//Type safety: The method getMethod(String, Class...)
		Method method = carClass.getMethod("setCarName", String.class);
		method.invoke(yourCar, "2023년형 New 소나타");
		System.out.println(yourCar.carName);   //2023년형 New 소나타
		System.out.println(myCar);             //나는 소나타입니다.
		System.out.println(myCar.carName);     //왜 널? 아직 carName 넣지 않음. 
	}
	
}
