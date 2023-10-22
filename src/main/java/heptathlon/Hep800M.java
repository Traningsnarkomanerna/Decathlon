package heptathlon;

import common.CalcTrackAndField;

public class Hep800M {
    private int score;
    private static final double A = 0.11193;
    private static final double B = 254;
    private static final double C = 1.88;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        // result = (int) (A * Math.pow((254-distance), C));
        // the score should be 0 if the result is not smaller than 254
        if (runningTime < 70) {
            System.out.println("Value too low");
            score = -1;
        } else if (runningTime >= 254) {
            score = 0;
        } else {
            score = calc.calculateTrack(A, B, C, runningTime);
        }
        return score;
    }

    public int getScore() {
        return score;
    }
}
