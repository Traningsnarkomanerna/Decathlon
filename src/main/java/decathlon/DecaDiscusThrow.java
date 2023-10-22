package decathlon;

import common.CalcTrackAndField;

public class DecaDiscusThrow {
    private int score;
    private static final double A = 12.91;
    private static final double B = 4;
    private static final double C = 1.1;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in meters.
    public int calculateResult(double distance) {
        // Acceptable values.
        if (distance <= 4) {
            score = 0;
        } else if (distance > 85) {
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
