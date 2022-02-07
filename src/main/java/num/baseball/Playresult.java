package num.baseball;

import java.util.function.IntPredicate;

public class Playresult {

	private int strike = 0;
	private int ball = 0;

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void report(BallStatus status) {
		if(status.isStrike()) {
			strike += 1;
		}
		if(status.isBall()) {
			ball += 1; 
		}
		
	}

	public Boolean isGameEnd() {
		return strike == 3;
	}

}
