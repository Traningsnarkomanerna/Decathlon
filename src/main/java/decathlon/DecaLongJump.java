package decathlon;

import common.*;

public class DecaLongJump {

	private int score;
	private double A = 0.14354;
	private double B = 220;
	private double C = 1.4;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();

	// Calculate the score based on distance and height. Measured in centimetres.
	public void calculateResult(double distance) {

		while (active) {
			//result = (int) (A * Math.pow((distance - 220), C));
			//according to this formula, the score should be 0 if the result is smaller than 220
			try {

				if (distance <= 220) {
					score=0;
					active = false;
				} else if (distance > 1500) {   //world record 8.95 m
					System.out.println("Value too high");
					distance = inputResult.enterResult();
				}
				else {

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
