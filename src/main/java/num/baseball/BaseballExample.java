package num.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseballExample {

	public static void main(String[] args) {
		
		List<Integer> comNums = new Balls().ComNum();
		Balls com = new Balls(comNums);
		
		while(true) {
			System.out.println(comNums);
			Scanner sc  = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요 : ");
			
			String[] inputs = sc.nextLine().split("");
			
			if(inputs.length < 3) {
				System.out.println("3자리 수를 입력해주세요");
				continue;
			}
			
			List<Integer> usernums = new ArrayList<Integer>();
			for (int i=0; i<3; i++) {
				usernums.add(Integer.parseInt(inputs[i]));
			}
			
			Playresult result = com.play(usernums);
			
			if( result.getBall() == 0 && result.getStrike() == 0 ) {
				System.out.println("낫싱");
				continue;
			}
			if( result.getBall() != 0 && result.getStrike() != 0) {
				System.out.println(result.getStrike() +" 스트라이크 "+ result.getBall() + " 볼");
				continue;
			}
			if( result.getStrike() != 0 && result.getStrike() != 3 && result.getBall() == 0) {
				System.out.println(result.getStrike() + " 스트라이크");
				continue;
			}
			if( result.getBall() != 0 ) {
				System.out.println(result.getBall() + " 볼");
				continue;
			}
			
			if (result.isGameEnd()) {
				System.out.println("3개를 모두 맞히셨습니다! 게임종료.");
				sc  = new Scanner(System.in);
				System.out.println("게임을 새로 진행하시려면 1 끝내시려면 2 를 입력해주세요.");
				
				int input = sc.nextInt();
				if(input == 2) {
					System.out.println("이용해 주셔서 감사합니다.");
					break;
				}
				comNums = new Balls().ComNum();
				com = new Balls(comNums);
				
				continue;
				
			}
			
			sc.close();
			
			
		}
		
	}

}
