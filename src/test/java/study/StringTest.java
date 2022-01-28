package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split() {
    	String[] actual = "1,2".split(",");
    	assertThat(actual).contains("1","2");
    }
    @Test
    void split2() {
    	String[] actual = "1".split(",");
    	assertThat(actual).containsExactly("1");
    }
    @Test
    void subString() {
    	String actual = "(1,2)";
    	String result = actual.substring(1, actual.length()-1);
    	assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName(value = "chatAt Exception 발생")
    void chat() {
    	String actual = "abc";
    	char result = actual.charAt(actual.length()-1);
    	assertThatThrownBy(()->{
    		throw new IndexOutOfBoundsException(result);
    	}).isInstanceOf(IndexOutOfBoundsException.class)
    	  .hasMessageContaining("Index");
    }
    
}
