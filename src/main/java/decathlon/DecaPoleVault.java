package decathlon;

import common.CalcTrackAndField;

public class DecaPoleVault {
    private int score;
    private double A = 0.2797;
    private double B = 100;
    private double C = 1.35;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in centimetres.
    public int calculateResult(double distance) {
        if (distance <= 100) {
            score = 0;
        } else if (distance > 1000) {
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
