package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import num.baseball.Ball;
import num.baseball.BallStatus;
import num.baseball.Balls;
import num.baseball.BaseballNum;
import num.baseball.Playresult;

public class BallsTest {
	
	private Balls com;
	
	@BeforeEach
	void setUp() {
		com = new Balls(Arrays.asList(1,2,3));
	}
	
	@Test
	void play_3strike_3ball() {
		Playresult result = com.play(Arrays.asList(1,2,3));
		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
		assertThat(result.isGameEnd()).isTrue();
	}
	
	@Test
	void play_1strike_1ball() {
		Playresult result = com.play(Arrays.asList(1,3,4));
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}
	
	@Test
	void play_nothing() {
		Playresult result = com.play(Arrays.asList(4,5,6));
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}
	
	@Test
	@DisplayName("com_list_user_no strike")
	void strike() {
		BallStatus status = com.play(new Ball(1,1));
		assertThat(status).isEqualTo(status.STRIKE);
	}
	
	@Test
	@DisplayName("com_list_user_no ball")
	void ball() {
		BallStatus status = com.play(new Ball(1,2));
		assertThat(status).isEqualTo(status.BALL);
	}
	
	@Test
	@DisplayName("com_list_user_no nothing")
	void nothing() {
		BallStatus status = com.play(new Ball(1,5));
		assertThat(status).isEqualTo(status.NOTHING);
	}
	
	@Test
	void RandomBall() {
		List<Integer> comnums = new Balls().ComNum();
		System.out.println(comnums);
		assertThat(BaseballNum.valid(comnums.get(0))).isTrue();
		assertThat(BaseballNum.valid(comnums.get(2))).isTrue();
	}
}
