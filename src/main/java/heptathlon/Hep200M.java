package heptathlon;

import common.CalcTrackAndField;

public class Hep200M {
    private int score;
    private double A = 4.99087;
    private double B = 42.5;
    private double C = 1.81;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        // Acceptable values.
        if (runningTime < 14) {
            System.out.println("Value too high");
            score = -1; // Score you can get if lower than 14 in this case, specifically 13.9
        } else if (runningTime >= 14 && runningTime <= 42.5) {
            score = calc.calculateTrack(A, B, C, runningTime);
        } else {
            score = 0; // Score you can get if you are higher than 42.08
        }
        return score;
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

    public int getScore() {
        return score;
    }
}
