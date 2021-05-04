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
	
}
