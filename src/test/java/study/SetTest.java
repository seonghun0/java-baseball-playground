package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		numbers = new HashSet<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(3);
	}
	
	@Test
	@DisplayName("set size check")
	void setsize() {
		int result = numbers.size();
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	@DisplayName("numbers 확인")
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1,2,3})
	@DisplayName("중복제거")
	void contains2(int number) {
		assertTrue((numbers).contains(number));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true","3:true","2:true","4:false","5:false"}, delimiter = ':')
	void check(int input, String expected) {
		boolean result = numbers.contains(input);
		String s = String.valueOf(result);
		assertEquals(expected,s);
	}
	
	
	
}
