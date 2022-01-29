package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*; 

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import practice.Calculator;

public class CalculatorTest {
	
	Calculator calc = new Calculator();
	
	@Test
	@DisplayName("더하기 테스트")
	void add() {
		assertEquals(7, calc.add("1", "6"));
	}
	
	@Test
	@DisplayName("빼기 테스트")
	void minus() {
		assertEquals(7, calc.minus("13", "6"));
	}
	
	@Test
	@DisplayName("곱하기 테스트")
	void multiply() {
		assertEquals(7, calc.multiply("1", "7"));
	}
	
	@Test
	@DisplayName("나누기 테스트")
	void divide() {
		assertEquals(0, calc.divide("1", "6"));
	}
	
	@Test
	@DisplayName("문자열 나누기")
	void seperate() {
		String input = "1 + 2 + 3";
		String[] inputs = {"1","+","2","+","3"};
		
		assertThat(calc.seperate(input)).isEqualTo(inputs);
		
	}
	
	@ParameterizedTest
	@CsvSource (value = {"9 - 5 + 1 * 3:15"," :0","1=3*4~0:16" }, delimiter = ':')
	@DisplayName("계산기 테스트")
	void Stringcalculator(String input, String output) {
		String[] inputs = calc.seperate(input);
		int result = calc.Stringcalculator(inputs);
		assertEquals(Integer.parseInt(output), result);
		
		
		
		
	}
	
}
