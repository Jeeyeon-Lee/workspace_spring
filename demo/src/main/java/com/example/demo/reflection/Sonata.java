package com.example.demo.reflection;

public class Sonata {
	int wheelNum;
	String carName;
	int speed;
	public int speedUp() {
		return speed++;
	}
	public int speedDown() {
		return speed--;
	}
	public String toString() {
		return "나는 소나타입니다.";
	}
	
	public int getWheelNum() {
		return wheelNum;
	}
	public void setWheelNum(int wheelNum) {
		this.wheelNum = wheelNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
