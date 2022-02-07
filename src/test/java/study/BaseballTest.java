package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import num.baseball.Ball;
import num.baseball.BallStatus;
import num.baseball.BaseballNum;

public class BaseballTest {
	
	@Test
	@DisplayName("숫자 1부터 9까지 체크")
	void BaseBallNumber() {
		assertThat(BaseballNum.valid(9)).isTrue();
		assertThat(BaseballNum.valid(1)).isTrue();
		assertThat(BaseballNum.valid(0)).isFalse();
		assertThat(BaseballNum.valid(11)).isFalse();
	}
	
	@Test
	void strike() {
		Ball com = new Ball(1,2);
		BallStatus status = com.play(new Ball(1,2));
		assertThat(status).isEqualTo(status.STRIKE);
	}
	
	@Test
	void ball() {
		Ball com = new Ball(1,2);
		BallStatus status = com.play(new Ball(2,2));
		assertThat(status).isEqualTo(status.BALL);
	}
	
	@Test
	void nothing() {
		Ball com = new Ball(1,2);
		BallStatus status = com.play(new Ball(1,3));
		assertThat(status).isEqualTo(status.NOTHING);
	}
	
}
