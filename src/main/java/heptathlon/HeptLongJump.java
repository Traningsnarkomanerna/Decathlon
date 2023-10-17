package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class HeptLongJump {

	private int score;
	private double A = 0.188807;
	private double B = 210;
	private double C = 1.41;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on distance and height. Measured in centimeters.
	public void calculateResult(double distance) {

		while (active) {

			try {
				//result = (int) (A * Math.pow((distance - 210), C));
				// any distance smaller than 210 will lead to score 0
				if (distance <= 210) {
					score=0;
					active = false;
				} else if (distance > 1100) {

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
	}
	public int getScore(){return score;}
}
