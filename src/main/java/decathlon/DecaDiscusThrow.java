package decathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class DecaDiscusThrow {

	private int score;
	private static final double A = 12.91;
	private static final double B = 4;
	private static final double C = 1.1;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on distance and height. Measured in meters.
	// result = (int) (A * Math.pow((distance - 4), C));
	public int calculateResult(double distance) {

		while (active) {

			try {
				// Acceptable values.
				if (distance <= 4) {
					score=0;
					active = false;
				} else if (distance > 85) {
					System.out.println("Value too high");
					distance = inputResult.enterResult();
				} else {
					score = calc.calculateField(A, B, C, distance);

					active = false;
				}
			} catch (Exception e) {

				System.out.println("Please enter numbers");
			}
		}
		System.out.println("The result is: " + score);

		return score;
	}

	public int getScore() {
		return score;
	}
}
