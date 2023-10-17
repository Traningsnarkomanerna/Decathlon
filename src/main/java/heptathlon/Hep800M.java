package heptathlon;

import common.*;

public class Hep800M {

	private int score;
	private static final double A = 0.11193;
	private static final double B = 254;
	private static final double C = 1.88;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on time. All running events.
	public void calculateResult(double runningTime) {

		while (active) {

			try {
				// result = (int) (A * Math.pow((254-distance), C));
				// the score should be 0 if the result is not smaller than 254
				if (runningTime >= 254) {
					score=0;
					active = false;
				} else {
					score = calc.calculateTrack(A, B, C, runningTime);
					active = false;
				}
			} catch (Exception e) {

				System.out.println("Please enter numbers");
			}
		}
		System.out.println("The result is " + score);

	}
	public int getScore() {
		return score;
	}
}
