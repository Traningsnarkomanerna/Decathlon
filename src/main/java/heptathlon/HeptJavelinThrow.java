package heptathlon;

import common.CalcTrackAndField;

public class HeptJavelinThrow {
    private int score;
    private double A = 15.9803;
    private double B = 3.8;
    private double C = 1.04;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in metres.
    public int calculateResult(double distance) {
        //the score should be 0 if the result is smaller than 3.8
        if (distance <= 3.8) {
            score = 0;
        } else if (distance > 100) {   //world record 80.00 m
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
