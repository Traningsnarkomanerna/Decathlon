package decathlon;

import common.CalcTrackAndField;

public class DecaLongJump {
    private int score;
    private double A = 0.14354;
    private double B = 220;
    private double C = 1.4;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in centimetres.
    public int calculateResult(double distance) {
        //result = (int) (A * Math.pow((distance - 220), C));
        //according to this formula, the score should be 0 if the result is smaller than 220
        if (distance <= 220) {
            score = 0;
        } else if (distance > 1500) {   //world record 8.95 m
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
