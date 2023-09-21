package heptathlon;

import common.*;

public class Hep200M {

	private int score;
	private double A = 4.99087;
	private double B = 42.5;
	private double C = 1.81;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on time. All running events.
	public void calculateResult(double runningTime) {

		try {
			// Acceptable values.
			if (runningTime < 14)
				score = 2158; // Score you can get if lower than 14 in this case, specifically 13.9
			else if (runningTime >= 14 && runningTime <= 42.08) {
				score = calc.calculateTrack(A, B, C, runningTime);
			} else {
				score = 0; // Score you can get if you are higher than 42.08
			}
		} catch (Exception e) {

			System.out.println("The result is: " + score);
		}
		/*
		while (active) {

			try {
				// Acceptable values.
				if (runningTime < 14) {
					System.out.println("Value too low");
					runningTime = inputResult.enterResult();
				} else if (runningTime > 42.08) {
					// get 1 point in 42.08sec
					System.out.println("Value too high");
					runningTime = inputResult.enterResult();
				} else {
					score = calc.calculateTrack(A, B, C, runningTime);
					active = false;
				}
			} catch (Exception e) {
				System.out.println("Please enter numbers");
			}
		}
		System.out.println("The result is " + score);
		 */



	}

	public int getScore() {return score;}
}
