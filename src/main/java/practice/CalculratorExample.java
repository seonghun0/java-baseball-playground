package practice;

import java.util.Scanner;

public class CalculratorExample {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 값:");
		
		String input = scanner.nextLine();
		System.out.println("출력 : "+ input);
		
		String[] values = calc.seperate(input);
		
		calc.Stringcalculator(values);
		
	}

}
