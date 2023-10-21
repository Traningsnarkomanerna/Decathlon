package decathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class DecaHighJump {

    private int score;
    private static final double A = 0.8465;
    private static final double B = 75;
    private static final double C = 1.42;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in centimeters.
    public int calculateResult(double distance) {

        while (active) {

            try {
                // result = (int) (A * Math.pow((distance - 75), C));
                //according to this formula, the score should be 0 if the result is smaller than 75
                if (distance <= 75) {
                    score = 0;
                    active = false;
                } else if (distance > 300) {
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
