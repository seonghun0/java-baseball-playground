package study;

import org.junit.jupiter.api.Test;

import num.baseball.BaseballSet;

import static org.assertj.core.api.Assertions.*; 

public class BaseballSetTest {

	BaseballSet bb = new BaseballSet();
	
	@Test
	void setnumberTest() {
		int s = bb.setnumber();
		assertThat(s).isBetween(100, 999);
	}
	
}
