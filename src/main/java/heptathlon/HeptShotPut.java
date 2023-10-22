package heptathlon;

import common.CalcTrackAndField;

public class HeptShotPut {
    private int score;
    private double A = 56.0211;
    private double B = 1.5;
    private double C = 1.05;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in meters.
    public int calculateResult(double distance) {
        if (distance < 1.5) {
            score = 0;
        } else if (distance > 30) {
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
