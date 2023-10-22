package heptathlon;

import common.CalcTrackAndField;

public class HeptLongJump {
    private int score;
    private double A = 0.188807;
    private double B = 210;
    private double C = 1.41;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in centimeters.
    public int calculateResult(double distance) {
        //result = (int) (A * Math.pow((distance - 210), C));
        if (distance <= 210) {
            score = 0;
        } else if (distance > 1500) {
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
