package practice;

import java.util.Scanner;

public class Calculator {

	public int add(String a, String b) {
		int result = Integer.parseInt(a) + Integer.parseInt(b); 
		return result;
	}
	
	public int minus(String a, String b) {
		int result = Integer.parseInt(a) - Integer.parseInt(b);
		return result;
	}
	
	public int multiply(String a, String b) {
		int result = Integer.parseInt(a) * Integer.parseInt(b);
		return result;
	}
	
	public int divide(String a, String b) {
		int result = Integer.parseInt(a) / Integer.parseInt(b);
		return result; 
	}
	
	//글자 나누기
	public String[] seperate(String input) {
		
		if(input == null ) {
			String[] result = {"0"};
			System.out.println("식이 잘못 되었습니다.");
			return result;
		}
		
		Scanner scanner = new Scanner(input);
		String value = scanner.nextLine();
		String value2 = value.replaceAll("\\~|=|\\,|\\`|\\;|\\:|\\'|\"", "+");
		String[] inputs = value2.split("\\s+");
		if(inputs[0] == value2) {
			String[] inputs1 = value2.split("");
			return inputs1;
		}
		
		return inputs;
	}
	
	//나눈글자 계산하기
	public int Stringcalculator(String[] inputs){
		String first = inputs[0];
		String s = null;
		String second = null;
		int result = 0;
		
		for (int i = 1; i < inputs.length; ) {
			s = inputs[i];
			System.out.println("symbol:" + s);
			second = inputs[ i + 1 ];
			
			if ( s.equals("+")) {
				result = add(first, second);
				System.out.println("결과 더하기:"+result);
			}
			if (s.equals("-")) {
				result = minus(first, second);
				System.out.println("결과 빼기 :"+result);
			}
			if (s.equals("*")) {
				result = multiply(first, second);
				System.out.println("결과 곱하기 :"+ result);
			}
			if (s.equals("/")) {
				result = divide(first, second);
				System.out.println("결과 나누기 :"+result);
			}
			
			first = Integer.toString(result);
			i = i + 2;
			
		}
			
		return result;
	}
}
