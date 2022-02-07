package num.baseball;

import java.io.InputStream;
import java.util.Scanner;

public class BaseballSet {
	
	public int setnumber() { //숫자 셋팅
		
		int setnumber = (int)Math.ceil(Math.random()*1000);
		
		return setnumber;
	}
	
	public String[] checknumber(int setnumber) { //숫자 유효검사
		
		BaseballSet bb = new BaseballSet();
		
		if (setnumber < 100) {
			return null;
		}
		
		String input2 = String.valueOf(setnumber);
		System.out.println(input2);
		String[] set = input2.split("");
		
		if(set[0].equals(set[1]) | set[0].equals(set[2]) | set[1].equals(set[2])) {
			return null;
		}
		
		return set;
	}
	
	public int checkset(String input, String[] set) {
		String[] inputs = input.split("");
		
		System.out.println(set[0]+set[1]+set[2]);
		
		String i1 = inputs[0];
		String i2 = inputs[1];
		String i3 = inputs[2];
		
		String s1 = set[0];
		String s2 = set[1];
		String s3 = set[2];
		
		int strike = 0;
		int ball = 0;
		
		if(i1.equals(s1)) {
			strike += 1;
		}  	
		if (i1.equals(s2)|i1.equals(s3)) {
			ball +=1;
		} 
		if (i2.equals(s2)) {
			strike += 1;
		}
		if (i2.equals(s1)|i2.equals(s3)) {
			ball += 1;
		}
		if (i3.equals(s3)) {
			strike += 1;
		}
		if (i3.equals(s1)|i3.equals(s2)) {
			ball += 1;
		}
		if (ball == 3) {
			System.out.println("3볼");
			return strike;
		}
		if (strike == 3) {
			System.out.println("3개를 모두 맞히셨습니다. 게임종료");
			return strike;
		}
		
		if((strike+ball)==0) {
			System.out.println("낫싱");
			return strike;
		}
		if((strike+ball)==1|(strike+ball)==2|(strike+ball)==3) {
			System.out.println(strike+"스트라이크 "+ball+"볼");
			return strike;
		}
		return strike;
	}
	
	public int playbaseball(String[] set) {
		
    	BaseballSet bb = new BaseballSet();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해 주세요 : ");
		String input = sc.nextLine();
		
		if(input.length() < 3) {
			System.out.println("3자리를 입력해주세요.");
			return 0;
		}
		 
		int strike = bb.checkset(input, set);
		
		return strike;
	}
	
	public static void main(String[] args) {
		
		BaseballSet bb = new BaseballSet();
		
		int s = 0;
		int strike = 0;
		
		while (true) {
			
			int setnumber = bb.setnumber();
			String[] set = bb.checknumber(setnumber);
			
			while (set == null) {
				setnumber = bb.setnumber();
				set = bb.checknumber(setnumber);
			}
			while(strike !=3) {
				strike = bb.playbaseball(set);
			}

			InputStream is = System.in;
			System.out.println("게임을 새로 시작할려면 1, 종료하려면 2를 입력해주세요.");
			Scanner sc2 = new Scanner(is);
			s = sc2.nextInt();
					
			if(s==1) {
				System.out.println("계속");
			}
			if(s==2) {
				System.out.println("끝");
				break;
			}
			
		}
		System.out.println("감사합니다.");
		
	}

}
