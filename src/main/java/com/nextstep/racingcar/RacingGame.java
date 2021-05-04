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
	
}
