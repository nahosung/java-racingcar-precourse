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
	}
	
	public static void racingPosition(){
		for (int j = 0; j < carList.size(); j++) {
			CarVO carVO = carList.get(j);
			carVO = racing(carVO);
			carList.set(j, carVO);
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
	
	
	
}
