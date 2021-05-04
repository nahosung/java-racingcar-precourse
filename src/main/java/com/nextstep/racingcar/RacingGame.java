package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {
	
	private static int count = 0;
	private static ArrayList<CarVO> carList;
	
	public static void inputName() {
		System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.next();
		ValidationUtils.errorMsg(ValidationUtils.validNameSplitComma(inputName), ValidationUtils.msg_01);
		String[] nameArr = inputName.split(",");
		carListAdd(nameArr);
	}
	
	public static void carListAdd(String[] nameArr){
		carList = new ArrayList<CarVO>();
		for (int i = 0; i < nameArr.length; i++) {
			ValidationUtils.errorMsg(ValidationUtils.validNameLength(nameArr[i]), ValidationUtils.msg_02);
			CarVO carVO = new CarVO();
			carVO.setName(nameArr[i]);
			carVO.setPosition(1);
			carList.add(carVO);
		}
	}
	
	public static void inputConut() {
		System.out.println("시도할 회수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		String inputCount = sc.next();
		ValidationUtils.errorMsg(ValidationUtils.validNumber(inputCount), ValidationUtils.msg_03);
		count = Integer.parseInt(inputCount);
	}
	
	public static void racingStart() {
		System.out.println("실행 결과");
		for (int i = 0; i < count; i++) {
			racingPosition();
		}
		resultRacing();
	}
	
	public static void racingPosition(){
		for (int j = 0; j < carList.size(); j++) {
			CarVO carVO = carList.get(j);
			carVO = racing(carVO);
			carList.set(j, carVO);
			printCarPosition(carVO);
		}
		System.out.println();
	}
	
	public static CarVO racing(CarVO carVO) {
		int number = createMoveNumber();
		CarVO racingCarVO = carVO;
		if (number > 3) {
			int position = carVO.getPosition();
			position += 1;
			racingCarVO.setPosition(position);
		}
		return racingCarVO;
	}
	
	public static int createMoveNumber() {
		int randomNumber = ValidationUtils.makeRandomNumber();
		ValidationUtils.errorMsg(ValidationUtils.validRandomNumber(randomNumber), ValidationUtils.msg_04);
		return randomNumber;
	}
	
	public static void printCarPosition(CarVO carVO){
		System.out.print(carVO.getName()+" : ");
		for (int i = 1; i <= carVO.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void resultRacing(){
		int maxPosition = 0;
		for (int i = 0; i < carList.size(); i++) {
			CarVO carVO = carList.get(i);
			maxPosition = maxPosition(maxPosition, carVO.getPosition());
		} 
		printRacingWin(maxPosition);
	}
	
	public static int maxPosition(int maxPosition, int position){
		if (maxPosition < position){
			return position;
		}
		return maxPosition;
	}
	
	public static void printRacingWin(int maxPosition){
		String name = "";
		for (int i = 0; i < carList.size(); i++) {
			CarVO carVO = carList.get(i);
			name += findWinner(maxPosition, carVO);
		} 
		System.out.println(name+"가 최종 우승했습니다.");
	}
	
	public static String findWinner(int maxPosition, CarVO carVO){
		if (maxPosition == carVO.getPosition()){
			return carVO.getName()+"\t";
		}
		return "";
	}
	
}
