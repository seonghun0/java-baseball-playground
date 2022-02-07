package num.baseball;

public class BaseballNum {


	private static int Min = 1;
	private static int Max = 10;

	public static Boolean valid(int no) {
		if ((no >= Min) && (no < Max)) {
			return true;
		}
		return false;
	}
}
