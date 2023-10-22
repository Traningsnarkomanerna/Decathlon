package decathlon;

import common.*;

public class Deca1500M {
    private int score;
    private static final double A = 0.03768;
    private static final double B = 480;
    private static final double C = 1.85;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        // Acceptable values.
        if (runningTime < 150) {
            System.out.println("Value too low");
            score = -1;
        } else if (runningTime > 480) {
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
