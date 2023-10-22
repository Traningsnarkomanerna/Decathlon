package decathlon;

import common.CalcTrackAndField;

public class DecaJavelinThrow {
    private int score;
    private double A = 10.14;
    private double B = 7;
    private double C = 1.08;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in meters.
    public int calculateResult(double distance) {
        if (distance < 7) {
            score = 0;
        } else if (distance > 110) {
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
