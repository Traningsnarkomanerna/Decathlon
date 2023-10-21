package decathlon;

import common.*;

public class Deca400M {

	private int score;
	private static final double A = 1.53775;
	private static final double B = 82;
	private static final double C = 1.81;
	boolean active = true;

	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on time. All running events.

	public void calculateResult(double runningTime) {

		while (active) {

			try {
				// Acceptable values.
				if (runningTime < 20) {
					System.out.println("Value too low");
					runningTime = inputResult.enterResult();
				} else if (runningTime >= 81) {
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
		System.out.println("The result is: " + score);

	}

	public int getScore() {
		return score;
	}
}
