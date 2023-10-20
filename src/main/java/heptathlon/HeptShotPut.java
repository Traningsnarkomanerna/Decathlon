package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class HeptShotPut {

	private int score;
	private double A = 56.0211;
	private double B = 1.5;
	private double C = 1.05;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on distance and height. Measured in meters.
	public void calculateResult(double distance) {

		while (active)

		try {
			if (distance >= 1.5 && distance <=30) {
				score = calc.calculateField(A, B, C, distance);
				active = false;
			} else {
				distance = inputResult.enterResult();
				System.out.println("Incorrect value");
			}
		} catch (Exception e) {
			System.out.println("Please enter numbers");
		}
		System.out.println("The result is: "+score);
}

	public int getScore() {
		return score;
	}
}
