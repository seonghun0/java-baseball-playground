package num.baseball;

public class Ball {

	private int position;
	private int ballno;

	public Ball(int position, int ballno) {
		this.position = position;
		this.ballno = ballno;
	}

	public BallStatus play(Ball userball) {
		
		if(userball.equals(this)) {
			return BallStatus.STRIKE;
		}
		
		if(userball.ballMatch(ballno)) {
			return BallStatus.BALL;
		}
		
		return BallStatus.NOTHING;
	}
	
	private boolean ballMatch(int ballno) {
		return this.ballno == ballno;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Ball) {
			Ball b = (Ball) obj;
			if( position == b.position && ballno == b.ballno) {
				return true;
			}
		}
		return false;
	}
	
}
