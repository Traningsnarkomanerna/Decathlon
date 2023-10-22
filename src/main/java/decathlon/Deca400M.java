package decathlon;

import common.*;

public class Deca400M {
    private int score;
    private static final double A = 1.53775;
    private static final double B = 82;
    private static final double C = 1.81;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        // Acceptable values.
        if (runningTime < 20) {
            System.out.println("Value too low");
            score = -1;
        } else if (runningTime >= 82) {
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
