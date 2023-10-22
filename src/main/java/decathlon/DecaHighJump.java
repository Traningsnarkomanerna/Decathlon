package decathlon;

import common.CalcTrackAndField;

public class DecaHighJump {
    private int score;
    private static final double A = 0.8465;
    private static final double B = 75;
    private static final double C = 1.42;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in centimeters.
    public int calculateResult(double distance) {
        // result = (int) (A * Math.pow((distance - 75), C));
        //according to this formula, the score should be 0 if the result is smaller than 75
        if (distance <= 75) {
            score = 0;
        } else if (distance > 300) {
            System.out.println("Value too high");
            score = -1;
        } else {
            score = calc.calculateField(A, B, C, distance);
        }
        return score;
    }

    public int getScore() {
        return score;
    }
}
