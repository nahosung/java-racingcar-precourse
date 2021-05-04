package com.nextstep.racingcar;

import java.util.Random;

public class ValidationUtils {
	public static final int MIN_LEGNTH = 1;
	public static final int MAX_LEGNTH = 5;
	public static final int MIN_NO = 0;
	public static final int MAX_NO = 9;
	
	public static final String msg_01 = "자동차 이름은 쉼표(,)로 구분하여 입력해야합니다.";
	public static final String msg_02 = "자동차 이름은 1자리 이상 5자리 이하로 입력가능합니다.";
	public static final String msg_03 = "회수는 숫자만 입력 가능합니다.";
	public static final String msg_04 = "램덤 숫자 생성 오류";
	
	public static boolean validNameSplitComma(String name) {
		String[] nameArr = name.split(",");
		if (nameArr.length > 1) {
			return true;
		}
		return false;
	}
	
	public static boolean validNameLength(String name) {
		int length = name.length();
		if (length < MIN_LEGNTH || length > MAX_LEGNTH) {
			return false;
		}
		return true;
	}
	
	public static boolean validNumber(String count) {
		return count.matches("[+-]?\\d*(\\.\\d+)?");
	}

	public static void errorMsg(boolean value, String msg) {
		if (value == false) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static boolean validRandomNumber(int number) {
		if(number < MIN_NO || number > MAX_NO) {
			return false;
		}
		return true;
	}

	public static int makeRandomNumber() {
		Random random = new Random();
		return random.nextInt(MAX_NO)+MIN_NO;
	}
	
}
