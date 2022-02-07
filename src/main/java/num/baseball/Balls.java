package num.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private List<Ball> balls;

	public Balls(List<Integer> comballs) {
		List<Ball> balls = mapball(comballs);
		this.balls = balls;
	}

	public Balls() {
	}

	private List<Ball> mapball(List<Integer> comballs) {
		List<Ball> balls = new ArrayList<Ball>();
		for (int i = 0; i < 3; i ++) {
			balls.add(new Ball(i+1, comballs.get(i)));
		}
		return balls;
	}
	
	public Playresult play(List<Integer> userballs) {
		Balls userball = new Balls(userballs); 
		Playresult result = new Playresult();
		for (Ball ball : balls) {
			BallStatus status = userball.play(ball);
			result.report(status);
		}
		return result;
	}

	public BallStatus play(Ball userballs) {
		return balls.stream()
				.map(comballs -> comballs.play(userballs))
				.filter(BallStatus::isNotNothing)
				.findFirst()
				.orElse(BallStatus.NOTHING);
	}
	
	public List<Integer> ComNum() {
		List<Integer> comnum = new ArrayList<Integer>();
		while( comnum.size() != 3 ) {
			
			comnum.add((int) (Math.random()*9+1));
			
			CheckComnum(comnum);
			   
		}
		return comnum;
	}

	private void CheckComnum(List<Integer> comnum) {
		if(comnum.size() == 3 ) {
			checkComnum2(comnum);
		}
	}

	private void checkComnum2(List<Integer> comnum) {
		if(comnum.get(0) == comnum.get(1) ||
		   comnum.get(0) == comnum.get(2) ||
		   comnum.get(1) == comnum.get(2)){
			
			comnum.removeAll(comnum);
		}
	}


}
