package decathlon;

import common.*;

public class Deca100M {

	private int score;
	private double A = 25.4347;
	private double B = 18;
	private double C = 1.81;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on time. All running events.  result = (int) (A * Math.pow((18 - distance), C));
	public void calculateResult(double runningTime) {
		while (active) {
			try {
				if (runningTime < 5 ) {
					System.out.println("Value too low");
					runningTime = inputResult.enterResult();
				} else if (runningTime>=18) {
					score=0;
					active = false;

				} else {
					score = calc.calculateTrack(A, B, C, runningTime);
					active = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
				runningTime = inputResult.enterResult();
			}
		}
		System.out.println("The result is " + score);

	}
		public int getScore() {
		return score;
		}
}

