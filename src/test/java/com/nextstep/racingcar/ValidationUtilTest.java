package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
	
	@Test
	@DisplayName("입력 받은 자동차 이름 구분 - 자동차 이름은 쉼표(,) 로 구분")
	void carNameSplitComma() {
		assertThat(ValidationUtils.validNameSplitComma("user1,user2")).isTrue();
		assertThat(ValidationUtils.validNameSplitComma("user1,user2,user3,")).isTrue();
		assertThat(ValidationUtils.validNameSplitComma("user1/user2")).isFalse();
		assertThat(ValidationUtils.validNameSplitComma("user1")).isFalse();
		assertThat(ValidationUtils.validNameSplitComma("")).isFalse();
		assertThat(ValidationUtils.validNameSplitComma(",")).isFalse();
	}
	
	@Test
	@DisplayName("입력 받은 자동차 이름 체크 - 자동차 이름은 5자 이하만 가능")
	void carNameLengthCheck() {
		assertThat(ValidationUtils.validNameLength("user1")).isTrue();
		assertThat(ValidationUtils.validNameLength("u")).isTrue();
		assertThat(ValidationUtils.validNameLength("user123")).isFalse();
		assertThat(ValidationUtils.validNameLength("")).isFalse();
	}
	
	@Test
	@DisplayName("입력 받은 숫자 체크 - 숫자가 아닌경우 에러 메시지 표시")
	void numberCheck() {
		assertThat(ValidationUtils.validNumber("0")).isTrue();
		assertThat(ValidationUtils.validNumber("1")).isTrue();
		assertThat(ValidationUtils.validNumber("9")).isTrue();
		assertThat(ValidationUtils.validNumber("999")).isTrue();
		assertThat(ValidationUtils.validNumber("test")).isFalse();
	}
	
}
